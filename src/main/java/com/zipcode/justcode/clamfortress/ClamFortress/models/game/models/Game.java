package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.utility.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId
    private User user;

    @Transient
    private Board gameBoard;

    @Transient
    public ActionManager actionManager;

    private Boolean toughEnemies;
    private Boolean hostileEnemies;
    private Boolean slowResourceGain;
    private Boolean frequentBadEvents;
    private Boolean terribleDisasters;
    private Boolean handicappedStartEquipment;
    private Boolean moreNetherworlds;
    private Boolean lessEffectiveTools;
    private Boolean limitedBlueprintAccess;
    private Boolean tradingEnabled;
    private Boolean magicEnabled;
    private Boolean aliensEnabled;
    private Boolean healingEnabled;
    private Boolean faithEnabled;
    private Boolean surroundingCheckEnabled;

    @Enumerated(EnumType.STRING)
    private Race playerRace;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    public Game() {
        this(new BronzeAge(true), Difficulty.DEFAULT, Race.HUMAN, new BlankBiome(), 5, 50, 50);
    }

    public Game(Era startEra, Difficulty gameDifficulty, Race chosenRace, AbstractBiome startingBiome, int startPopCap, int xMax, int yMax) {
        TechTree.resetTechTree();
        if (startEra != null) {
            TechTree.moveToEra(startEra, true);
        }
        PriorityManager.reset(true);
        this.difficulty = gameDifficulty;
        this.actionManager = new ActionManager();
        this.playerRace = chosenRace;
        this.gameBoard = new Board();
        Archive.getInstance().get("wood");
        gameBoard = new Board(startingBiome, xMax, yMax, startPopCap);
        updateDifficultyBools();
        GameManager.getInstance().setNethermod(difficulty.getNethermod());
    }

    // Custom Difficulty
    public Game(Era startEra, Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractBiome startingBiome, int startPopCap, int xMax, int yMax) {
        TechTree.resetTechTree();
        if (startEra != null) {
            TechTree.moveToEra(startEra, true);
        }
        PriorityManager.reset(true);
        this.difficulty = Difficulty.CUSTOM;
        actionManager = new ActionManager();
        this.playerRace = chosenRace;
        gameBoard = new Board();
        Archive.getInstance().get("wood");
        gameBoard = new Board(startingBiome, xMax, yMax, startPopCap);
        this.toughEnemies = customDifficultyMods.contains(1);
        this.slowResourceGain = customDifficultyMods.contains(2);
        this.frequentBadEvents = customDifficultyMods.contains(3);
        this.terribleDisasters = customDifficultyMods.contains(4);
        this.handicappedStartEquipment = customDifficultyMods.contains(5);
        this.moreNetherworlds = customDifficultyMods.contains(6);
        this.hostileEnemies = customDifficultyMods.contains(8);
        this.lessEffectiveTools = customDifficultyMods.contains(7);
        this.limitedBlueprintAccess = customDifficultyMods.contains(9);
        this.tradingEnabled = !customDifficultyMods.contains(10);
        this.magicEnabled = !customDifficultyMods.contains(11);
        this.aliensEnabled = !customDifficultyMods.contains(12);
        this.healingEnabled = !customDifficultyMods.contains(13);
        this.faithEnabled = !customDifficultyMods.contains(14);
        this.surroundingCheckEnabled = !customDifficultyMods.contains(15);
        GameManager.getInstance().setNethermod(difficulty.getNethermod());
    }

    public void postSetup(int startPop) {
        if (!this.getGameBoard().getStartBiome().toString().equals("Debug")) {
            gameBoard.discover(getVillage().getBaseNode());
        }
        new NewSurvivors(false).addToVillage(startPop);
        getVillage().addResource(new Wood(), 100);
    }

    public ArrayList<GameObject> getModifierObjects() {
        ArrayList<GameObject> mods = new ArrayList<>(getVillage().getAllResources());
        for (Map.Entry<AbstractItem, Integer> entry : getVillage().getInventory().getEntrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                mods.add(entry.getKey());
            }
        }
        mods.addAll(getVillage().getBuildings());
        mods.addAll(getGameBoard().getAnimals());
        //mods.add(getVillage().getFarmland());
        return mods;
    }

    public Boolean canRaid() {
        return GameManager.getInstance().getRaidable().size() > 0;
    }

    public void handleEncounter(AbstractEncounter enc) {
        if (gameBoard.getVillage().canRunEncounter(enc)) {
            OutputManager.addToBot("SPECIAL ENCOUNTER :: " + enc.toString());
            enc.runEncounter();
            for (GameObject obj : this.getModifierObjects()) {
                obj.onRunSpecialEncounter(enc);
            }
        }
    }

    public Integer encounterLogic(ArrayList<AbstractEncounter> encounters) {
        Integer dateInc = GameManager.getInstance().advanceDate(5, 15);
        for (AbstractEncounter enc : encounters) {
            handleEncounter(enc);
        }
        int highEnd = 45;
        for (GameObject obj : this.getModifierObjects()) {
            highEnd += obj.modifyDateIncrease();
        }
        if (highEnd < 45) { highEnd = 45; }
        int low = 25 - dateInc;
        int high = highEnd - dateInc;
        if (low < 0) { low = 0; }
        if (high < 1) { high = 1; }
        dateInc += GameManager.getInstance().advanceDate(low, high);
        return dateInc;
    }

    public Integer getDateInc() {
        Integer dateInc = 0;
        ArrayList<AbstractEncounter> encounters = EncounterManager.generateEncounters();
        if (encounters.size() > 0) {
            dateInc += encounterLogic(encounters);
        } else {
            int highEnd = 45;
            for (GameObject obj : this.getModifierObjects()) {
                highEnd += obj.modifyDateIncrease();
            }
            if (highEnd < 45) { highEnd = 45; }
            dateInc += GameManager.getInstance().advanceDate(25, highEnd);
        }
        return dateInc;
    }

    public void advanceTurn() {
        int dateInc = getDateInc();
        for (GameObject obj : this.getModifierObjects()) {
            obj.onDateAdvance(dateInc);
        }
        StatTracker.incScore(dateInc);
        GameManager.getInstance().incTurns();
        queueEvergreenActions(dateInc);
        if (this.getVillage().getVistingMerchants().size() > 0) {
            this.getVillage().getVistingMerchants().get(0).visit();
        }
        runActions();
        this.getVillage().updateHP();
        PriorityManager.reset(this.difficulty.compareTo(Difficulty.HARD) > 0);
        for (GameObject obj : this.getModifierObjects()) {
            obj.endPhase();
        }

    }

    public void runActions() {
        while (!actionManager.actions.isEmpty() || !actionManager.preTurnActions.isEmpty() || !actionManager.postTurnActions.isEmpty() || (actionManager.finalAction != null && !actionManager.finalAction.isDone)) {
            actionManager.update();
        }
    }

    public void queueEvergreenActions(int dateInc) {
        actionManager.addToTurnStart(new NewSurvivors(true));
        actionManager.addToTurnEnd(new EndPhaseHunger());
        if (getVillage().getUncompletedBuildings().size() > 0) {
            actionManager.addToBottom(new Building(PriorityManager.getBuild()));
        }
        actionManager.addToBottom(new Engineering(PriorityManager.getEngineer()));
        actionManager.setAbsoluteLastAction(new EndTurnReport(dateInc));
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public Boolean getSurroundingCheckEnabled() {
        return surroundingCheckEnabled;
    }

    public Race getPlayerRace() {
        return playerRace;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Village getVillage() {
        return gameBoard.getVillage();
    }

    private void updateDifficultyBools() {
        switch (difficulty) {
            case DEFAULT:
                // Bad
                toughEnemies = true;
                moreNetherworlds = true;

                // Good
                hostileEnemies = false;
                slowResourceGain = false;
                frequentBadEvents = false;
                terribleDisasters = false;
                handicappedStartEquipment = false;
                limitedBlueprintAccess = false;
                lessEffectiveTools = false;
                tradingEnabled = true;
                magicEnabled = true;
                faithEnabled = true;
                aliensEnabled = true;
                healingEnabled = true;
                surroundingCheckEnabled = true;
                break;
            case HARD:
                // Bad
                toughEnemies = true;
                hostileEnemies = true;
                handicappedStartEquipment = true;
                moreNetherworlds = true;
                faithEnabled = false;
                tradingEnabled = false;

                // Good
                slowResourceGain = false;
                frequentBadEvents = false;
                terribleDisasters = false;
                lessEffectiveTools = false;
                limitedBlueprintAccess = false;
                magicEnabled = true;
                aliensEnabled = true;
                healingEnabled = true;
                surroundingCheckEnabled = true;
                break;
            case BRUTAL:
                // Bad
                toughEnemies = true;
                hostileEnemies = true;
                handicappedStartEquipment = true;
                moreNetherworlds = true;
                faithEnabled = false;
                tradingEnabled = false;
                slowResourceGain = true;
                frequentBadEvents = true;
                surroundingCheckEnabled = false;

                // Good
                terribleDisasters = false;
                lessEffectiveTools = false;
                limitedBlueprintAccess = false;
                magicEnabled = true;
                aliensEnabled = true;
                healingEnabled = true;
                break;
            case NIGHTMARE:
                // Bad
                toughEnemies = true;
                hostileEnemies = true;
                handicappedStartEquipment = true;
                moreNetherworlds = true;
                faithEnabled = false;
                tradingEnabled = false;
                slowResourceGain = true;
                frequentBadEvents = true;
                surroundingCheckEnabled = false;
                terribleDisasters = true;
                lessEffectiveTools = true;
                limitedBlueprintAccess = true;

                // Good
                magicEnabled = true;
                aliensEnabled = true;
                healingEnabled = true;
                break;
            case IMPOSSIBLE:
                // All bad
                toughEnemies = true;
                hostileEnemies = true;
                slowResourceGain = true;
                frequentBadEvents = true;
                terribleDisasters = true;
                handicappedStartEquipment = true;
                moreNetherworlds = true;
                lessEffectiveTools = true;
                limitedBlueprintAccess = true;
                tradingEnabled = false;
                magicEnabled = false;
                faithEnabled = false;
                aliensEnabled = false;
                healingEnabled = false;
                surroundingCheckEnabled = false;
                break;
            default:
                // All good
                toughEnemies = false;
                hostileEnemies = false;
                slowResourceGain = false;
                frequentBadEvents = false;
                terribleDisasters = false;
                handicappedStartEquipment = false;
                moreNetherworlds = false;
                lessEffectiveTools = false;
                limitedBlueprintAccess = false;
                tradingEnabled = true;
                magicEnabled = true;
                faithEnabled = true;
                aliensEnabled = true;
                healingEnabled = true;
                surroundingCheckEnabled = true;
                break;
        }
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Boolean getToughEnemies() {
        return toughEnemies;
    }

    public Boolean getHostileEnemies() {
        return hostileEnemies;
    }

    public Boolean getSlowResourceGain() {
        return slowResourceGain;
    }

    public Boolean getFrequentBadEvents() {
        return frequentBadEvents;
    }

    public Boolean getTerribleDisasters() {
        return terribleDisasters;
    }

    public Boolean getHandicappedStartEquipment() {
        return handicappedStartEquipment;
    }

    public Boolean getMoreNetherworlds() {
        return moreNetherworlds;
    }

    public Boolean getLessEffectiveTools() {
        return lessEffectiveTools;
    }

    public Boolean getLimitedBlueprintAccess() {
        return limitedBlueprintAccess;
    }

    public Boolean getTradingEnabled() {
        return tradingEnabled;
    }

    public Boolean getMagicEnabled() {
        return magicEnabled;
    }

    public Boolean getAliensEnabled() {
        return aliensEnabled;
    }

    public Boolean getHealingEnabled() {
        return healingEnabled;
    }

    public Boolean getFaithEnabled() {
        return faithEnabled;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public void setToughEnemies(Boolean toughEnemies) {
        this.toughEnemies = toughEnemies;
    }

    public void setHostileEnemies(Boolean hostileEnemies) {
        this.hostileEnemies = hostileEnemies;
    }

    public void setSlowResourceGain(Boolean slowResourceGain) {
        this.slowResourceGain = slowResourceGain;
    }

    public void setFrequentBadEvents(Boolean frequentBadEvents) {
        this.frequentBadEvents = frequentBadEvents;
    }

    public void setTerribleDisasters(Boolean terribleDisasters) {
        this.terribleDisasters = terribleDisasters;
    }

    public void setHandicappedStartEquipment(Boolean handicappedStartEquipment) {
        this.handicappedStartEquipment = handicappedStartEquipment;
    }

    public void setMoreNetherworlds(Boolean moreNetherworlds) {
        this.moreNetherworlds = moreNetherworlds;
    }

    public void setLessEffectiveTools(Boolean lessEffectiveTools) {
        this.lessEffectiveTools = lessEffectiveTools;
    }

    public void setLimitedBlueprintAccess(Boolean limitedBlueprintAccess) {
        this.limitedBlueprintAccess = limitedBlueprintAccess;
    }

    public void setTradingEnabled(Boolean tradingEnabled) {
        this.tradingEnabled = tradingEnabled;
    }

    public void setMagicEnabled(Boolean magicEnabled) {
        this.magicEnabled = magicEnabled;
    }

    public void setAliensEnabled(Boolean aliensEnabled) {
        this.aliensEnabled = aliensEnabled;
    }

    public void setHealingEnabled(Boolean healingEnabled) {
        this.healingEnabled = healingEnabled;
    }

    public void setFaithEnabled(Boolean faithEnabled) {
        this.faithEnabled = faithEnabled;
    }

    public void setSurroundingCheckEnabled(Boolean surroundingCheckEnabled) {
        this.surroundingCheckEnabled = surroundingCheckEnabled;
    }

    public void setPlayerRace(Race playerRace) {
        this.playerRace = playerRace;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }


}
