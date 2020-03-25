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
import java.util.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "game", targetEntity = Board.class)
    private static Board gameBoard;

    @Transient
    public  static ActionManager actionManager;

    @Transient
    private static GameManager gameManager;

    @Column(nullable = false, name = "toughEnemies")
    private static Boolean toughEnemies;

    @Column(nullable = false, name = "hostileEnemies")
    private static Boolean hostileEnemies;

    @Column(nullable = false, name = "slowResourceGain")
    private static Boolean slowResourceGain;

    @Column(nullable = false, name = "frequentBadEvents")
    private static Boolean frequentBadEvents;

    @Column(nullable = false, name = "terribleDisasters")
    private static Boolean terribleDisasters;

    @Column(nullable = false, name = "handicappedStartEquipment")
    private static Boolean handicappedStartEquipment;

    @Column(nullable = false, name = "moreNetherworlds")
    private static Boolean moreNetherworlds;

    @Column(nullable = false, name = "lessEffectiveTools")
    private static Boolean lessEffectiveTools;

    @Column(nullable = false, name = "limitedBlueprintAccess")
    private static Boolean limitedBlueprintAccess;

    @Column(nullable = false, name = "tradingEnabled")
    private static Boolean tradingEnabled;

    @Column(nullable = false, name = "magicEnabled")
    private static Boolean magicEnabled;

    @Column(nullable = false, name = "aliensEnabled")
    private static Boolean aliensEnabled;

    @Column(nullable = false, name = "healingEnabled")
    private static Boolean healingEnabled;

    @Column(nullable = false, name = "faithEnabled")
    private static Boolean faithEnabled;

    @Column(nullable = false, name = "surroundingCheckEnabled")
    private static Boolean surroundingCheckEnabled;

    @Column(nullable = false, name = "playerRace")
    private static Race playerRace;

    @Column(nullable = false, name = "difficulty")
    private static Difficulty difficulty;

    public Game() {}



    // Default Settings (for tests)
    public static void startGame() {
        startGame(new BronzeAge(true), Difficulty.DEFAULT, Race.HUMAN, new BlankBiome(), 0, 5, 50, 50);
    }

    public static void startGame(Era startEra, Difficulty gameDifficulty, Race chosenRace, AbstractBiome startingBiome, int startPop, int startPopCap, int xMax, int yMax) {
        TechTree.resetTechTree();
        if (startEra != null) {
            TechTree.moveToEra(startEra, true);
        }
        PriorityManager.reset(true);
        difficulty = gameDifficulty;
        actionManager = new ActionManager();
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board();
        Archive.getInstance().get("wood");
        gameBoard = new Board(startingBiome, xMax, yMax, startPopCap);
        if (!startingBiome.toString().equals("Debug")) {
            gameBoard.discover(getVillage().getBaseNode());
        }
        new NewSurvivors(false).addToVillage(startPop);
        getVillage().addResource(new Wood(), 100);
        updateDifficultyBools();
        gameManager.setNethermod(difficulty.getNethermod());
    }

    // Custom Difficulty
    public static void startGame(Era startEra, Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractBiome startingBiome, int startPop, int startPopCap, int xMax, int yMax) {
        TechTree.resetTechTree();
        if (startEra != null) {
            TechTree.moveToEra(startEra, true);
        }
        PriorityManager.reset(true);
        difficulty = Difficulty.CUSTOM;
        actionManager = new ActionManager();
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board();
        Archive.getInstance().get("wood");
        gameBoard = new Board(startingBiome, xMax, yMax, startPopCap);
        if (!startingBiome.toString().equals("Debug")) {
            gameBoard.discover(getVillage().getBaseNode());
        }
        new NewSurvivors(false).addToVillage(startPop);
        getVillage().addResource(new Wood(), 100);
        toughEnemies = customDifficultyMods.contains(1);
        slowResourceGain = customDifficultyMods.contains(2);
        frequentBadEvents = customDifficultyMods.contains(3);
        terribleDisasters = customDifficultyMods.contains(4);
        handicappedStartEquipment = customDifficultyMods.contains(5);
        moreNetherworlds = customDifficultyMods.contains(6);
        hostileEnemies = customDifficultyMods.contains(8);
        lessEffectiveTools = customDifficultyMods.contains(7);
        limitedBlueprintAccess = customDifficultyMods.contains(9);
        tradingEnabled = !customDifficultyMods.contains(10);
        magicEnabled = !customDifficultyMods.contains(11);
        aliensEnabled = !customDifficultyMods.contains(12);
        healingEnabled = !customDifficultyMods.contains(13);
        faithEnabled = !customDifficultyMods.contains(14);
        surroundingCheckEnabled = !customDifficultyMods.contains(15);
        gameManager.setNethermod(difficulty.getNethermod());
    }

    public static ArrayList<GameObject> getModifierObjects() {
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

    public static Boolean canRaid() {
        return GameManager.getInstance().getRaidable().size() > 0;
    }

    public static void handleEncounter(AbstractEncounter enc) {
        if (gameBoard.getVillage().canRunEncounter(enc)) {
            OutputManager.addToBot("SPECIAL ENCOUNTER :: " + enc.toString());
            enc.runEncounter();
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onRunSpecialEncounter(enc);
            }
        }
    }

    public static Integer encounterLogic(ArrayList<AbstractEncounter> encounters) {
        Integer dateInc = gameManager.advanceDate(5, 15);
        for (AbstractEncounter enc : encounters) {
            handleEncounter(enc);
        }
        int highEnd = 45;
        for (GameObject obj : Game.getModifierObjects()) {
            highEnd += obj.modifyDateIncrease();
        }
        if (highEnd < 45) { highEnd = 45; }
        int low = 25 - dateInc;
        int high = highEnd - dateInc;
        if (low < 0) { low = 0; }
        if (high < 1) { high = 1; }
        dateInc += gameManager.advanceDate(low, high);
        return dateInc;
    }

    public static Integer getDateInc() {
        Integer dateInc = 0;
        ArrayList<AbstractEncounter> encounters = EncounterManager.generateEncounters();
        if (encounters.size() > 0) {
            dateInc += encounterLogic(encounters);
        } else {
            int highEnd = 45;
            for (GameObject obj : Game.getModifierObjects()) {
                highEnd += obj.modifyDateIncrease();
            }
            if (highEnd < 45) { highEnd = 45; }
            dateInc += gameManager.advanceDate(25, highEnd);
        }
        return dateInc;
    }

    public static void advanceTurn() {
        int dateInc = getDateInc();
        for (GameObject obj : Game.getModifierObjects()) {
            obj.onDateAdvance(dateInc);
        }
        StatTracker.incScore(dateInc);
        gameManager.incTurns();
        queueEvergreenActions(dateInc);
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            Game.getVillage().getVistingMerchants().get(0).visit();
        }
        runActions();
        Game.getVillage().updateHP();
        PriorityManager.reset(difficulty.compareTo(Difficulty.HARD) > 0);
        for (GameObject obj : Game.getModifierObjects()) {
            obj.endPhase();
        }

    }

    public static void runActions() {
        while (!actionManager.actions.isEmpty() || !actionManager.preTurnActions.isEmpty() || !actionManager.postTurnActions.isEmpty() || (actionManager.finalAction != null && !actionManager.finalAction.isDone)) {
            actionManager.update();
        }
    }

    public static void queueEvergreenActions(int dateInc) {
        actionManager.addToTurnStart(new NewSurvivors(true));
        actionManager.addToTurnEnd(new EndPhaseHunger());
        if (getVillage().getUncompletedBuildings().size() > 0) {
            actionManager.addToBottom(new Building(PriorityManager.getBuild()));
        }
        actionManager.addToBottom(new Engineering(PriorityManager.getEngineer()));
        actionManager.setAbsoluteLastAction(new EndTurnReport(dateInc));
    }

    public static Board getGameBoard() {
        return gameBoard;
    }

    public static GameManager getGameManager() {
        return gameManager;
    }

    public static Boolean getSurroundingCheckEnabled() {
        return surroundingCheckEnabled;
    }

    public static Race getPlayerRace() {
        return playerRace;
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static Village getVillage() {
        return gameBoard.getVillage();
    }

    private static void updateDifficultyBools() {
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

    public static ActionManager getActionManager() {
        return actionManager;
    }

    public static Boolean getToughEnemies() {
        return toughEnemies;
    }

    public static Boolean getHostileEnemies() {
        return hostileEnemies;
    }

    public static Boolean getSlowResourceGain() {
        return slowResourceGain;
    }

    public static Boolean getFrequentBadEvents() {
        return frequentBadEvents;
    }

    public static Boolean getTerribleDisasters() {
        return terribleDisasters;
    }

    public static Boolean getHandicappedStartEquipment() {
        return handicappedStartEquipment;
    }

    public static Boolean getMoreNetherworlds() {
        return moreNetherworlds;
    }

    public static Boolean getLessEffectiveTools() {
        return lessEffectiveTools;
    }

    public static Boolean getLimitedBlueprintAccess() {
        return limitedBlueprintAccess;
    }

    public static Boolean getTradingEnabled() {
        return tradingEnabled;
    }

    public static Boolean getMagicEnabled() {
        return magicEnabled;
    }

    public static Boolean getAliensEnabled() {
        return aliensEnabled;
    }

    public static Boolean getHealingEnabled() {
        return healingEnabled;
    }

    public static Boolean getFaithEnabled() {
        return faithEnabled;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void setGameBoard(Board gameBoard) {
        Game.gameBoard = gameBoard;
    }

    public static void setActionManager(ActionManager actionManager) {
        Game.actionManager = actionManager;
    }

    public static void setGameManager(GameManager gameManager) {
        Game.gameManager = gameManager;
    }

    public static void setToughEnemies(Boolean toughEnemies) {
        Game.toughEnemies = toughEnemies;
    }

    public static void setHostileEnemies(Boolean hostileEnemies) {
        Game.hostileEnemies = hostileEnemies;
    }

    public static void setSlowResourceGain(Boolean slowResourceGain) {
        Game.slowResourceGain = slowResourceGain;
    }

    public static void setFrequentBadEvents(Boolean frequentBadEvents) {
        Game.frequentBadEvents = frequentBadEvents;
    }

    public static void setTerribleDisasters(Boolean terribleDisasters) {
        Game.terribleDisasters = terribleDisasters;
    }

    public static void setHandicappedStartEquipment(Boolean handicappedStartEquipment) {
        Game.handicappedStartEquipment = handicappedStartEquipment;
    }

    public static void setMoreNetherworlds(Boolean moreNetherworlds) {
        Game.moreNetherworlds = moreNetherworlds;
    }

    public static void setLessEffectiveTools(Boolean lessEffectiveTools) {
        Game.lessEffectiveTools = lessEffectiveTools;
    }

    public static void setLimitedBlueprintAccess(Boolean limitedBlueprintAccess) {
        Game.limitedBlueprintAccess = limitedBlueprintAccess;
    }

    public static void setTradingEnabled(Boolean tradingEnabled) {
        Game.tradingEnabled = tradingEnabled;
    }

    public static void setMagicEnabled(Boolean magicEnabled) {
        Game.magicEnabled = magicEnabled;
    }

    public static void setAliensEnabled(Boolean aliensEnabled) {
        Game.aliensEnabled = aliensEnabled;
    }

    public static void setHealingEnabled(Boolean healingEnabled) {
        Game.healingEnabled = healingEnabled;
    }

    public static void setFaithEnabled(Boolean faithEnabled) {
        Game.faithEnabled = faithEnabled;
    }

    public static void setSurroundingCheckEnabled(Boolean surroundingCheckEnabled) {
        Game.surroundingCheckEnabled = surroundingCheckEnabled;
    }

    public static void setPlayerRace(Race playerRace) {
        Game.playerRace = playerRace;
    }

    public static void setDifficulty(Difficulty difficulty) {
        Game.difficulty = difficulty;
    }
}
