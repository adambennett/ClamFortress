package clamFortress.game;

import clamFortress.actions.*;
import clamFortress.encounters.*;
import clamFortress.encounters.bandits.*;
import clamFortress.encounters.disasters.*;
import clamFortress.encounters.miracles.*;
import clamFortress.encounters.plagues.*;
import clamFortress.encounters.raids.*;
import clamFortress.enums.*;
import clamFortress.game.logic.*;
import clamFortress.game.regions.*;
import clamFortress.models.*;
import clamFortress.models.beings.player.*;
import clamFortress.models.buildings.abstracts.*;
import clamFortress.tech.eras.*;
import clamFortress.utilities.persistence.*;

import javax.swing.*;
import java.util.*;
import java.util.logging.*;

public class Game {

    // Nested Objects
    public ActionManager actionManager;
    public PriorityManager priorityManager;
    private final Board gameBoard;
    private final GameManager gameManager;
    private final Village village;

    // Difficulty Modifiers
    private final Boolean toughEnemies;
    private final Boolean hostileEnemies;
    private final Boolean slowResourceGain;
    private final Boolean frequentBadEvents;
    private final Boolean terribleDisasters;
    private final Boolean handicappedStartEquipment;
    private final Boolean moreNetherworlds;
    private final Boolean lessEffectiveTools;
    private final Boolean limitedBlueprintAccess;
    private final Boolean tradingEnabled;
    private final Boolean magicEnabled;
    private final Boolean aliensEnabled;
    private final Boolean healingEnabled;
    private final Boolean faithEnabled;
    private final Boolean surroundingCheckEnabled;
    private final Race playerRace;
    private final Modes difficulty;

    // Default Settings (for tests)
    public Game() {
        this(Modes.DEFAULT, Race.HUMAN, new Grasslands());
    }

    // Custom Difficulty
    public Game(Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractRegion startingBiome) {
        this.actionManager = new ActionManager();
        this.priorityManager = new PriorityManager();
        this.difficulty = Modes.CUSTOM;
        this.playerRace = chosenRace;
        this.gameManager = GameManager.getInstance();
        this.gameBoard = new Board();
        this.village = new Village(startingBiome, new StoneAge());
        this.village.incPopCap(5);
        this.village.incWood(100);
        // TODO: Add 5 villagers of the chosen race to the village
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
    }

    public Game(Modes gameDifficulty, Race chosenRace, AbstractRegion startingBiome) {
        this.actionManager = new ActionManager();
        this.priorityManager = new PriorityManager();
        this.difficulty = gameDifficulty;
        this.playerRace = chosenRace;
        this.gameManager = GameManager.getInstance();
        this.gameBoard = new Board();
        this.village = new Village(startingBiome, new StoneAge());
        this.village.incPopCap(5);
        this.village.incWood(100);
        // TODO: Add 5 villagers of the chosen race to the village
        switch (difficulty) {
            case DEFAULT:
                // Bad
                this.toughEnemies = true;
                this.moreNetherworlds = true;

                // Good
                this.hostileEnemies = false;
                this.slowResourceGain = false;
                this.frequentBadEvents = false;
                this.terribleDisasters = false;
                this.handicappedStartEquipment = false;
                this.limitedBlueprintAccess = false;
                this.lessEffectiveTools = false;
                this.tradingEnabled = true;
                this.magicEnabled = true;
                this.faithEnabled = true;
                this.aliensEnabled = true;
                this.healingEnabled = true;
                this.surroundingCheckEnabled = true;
                break;
            case HARD:
                // Bad
                this.toughEnemies = true;
                this.hostileEnemies = true;
                this.handicappedStartEquipment = true;
                this.moreNetherworlds = true;
                this.faithEnabled = false;
                this.tradingEnabled = false;

                // Good
                this.slowResourceGain = false;
                this.frequentBadEvents = false;
                this.terribleDisasters = false;
                this.lessEffectiveTools = false;
                this.limitedBlueprintAccess = false;
                this.magicEnabled = true;
                this.aliensEnabled = true;
                this.healingEnabled = true;
                this.surroundingCheckEnabled = true;
                break;
            case BRUTAL:
                // Bad
                this.toughEnemies = true;
                this.hostileEnemies = true;
                this.handicappedStartEquipment = true;
                this.moreNetherworlds = true;
                this.faithEnabled = false;
                this.tradingEnabled = false;
                this.slowResourceGain = true;
                this.frequentBadEvents = true;
                this.surroundingCheckEnabled = false;

                // Good
                this.terribleDisasters = false;
                this.lessEffectiveTools = false;
                this.limitedBlueprintAccess = false;
                this.magicEnabled = true;
                this.aliensEnabled = true;
                this.healingEnabled = true;
                break;
            case NIGHTMARE:
                // Bad
                this.toughEnemies = true;
                this.hostileEnemies = true;
                this.handicappedStartEquipment = true;
                this.moreNetherworlds = true;
                this.faithEnabled = false;
                this.tradingEnabled = false;
                this.slowResourceGain = true;
                this.frequentBadEvents = true;
                this.surroundingCheckEnabled = false;
                this.terribleDisasters = true;
                this.lessEffectiveTools = true;
                this.limitedBlueprintAccess = true;

                // Good
                this.magicEnabled = true;
                this.aliensEnabled = true;
                this.healingEnabled = true;
                break;
            case IMPOSSIBLE:
                // All bad
                this.toughEnemies = true;
                this.hostileEnemies = true;
                this.slowResourceGain = true;
                this.frequentBadEvents = true;
                this.terribleDisasters = true;
                this.handicappedStartEquipment = true;
                this.moreNetherworlds = true;
                this.lessEffectiveTools = true;
                this.limitedBlueprintAccess = true;
                this.tradingEnabled = false;
                this.magicEnabled = false;
                this.faithEnabled = false;
                this.aliensEnabled = false;
                this.healingEnabled = false;
                this.surroundingCheckEnabled = false;
                break;
            default:
                // All good
                this.toughEnemies = false;
                this.hostileEnemies = false;
                this.slowResourceGain = false;
                this.frequentBadEvents = false;
                this.terribleDisasters = false;
                this.handicappedStartEquipment = false;
                this.moreNetherworlds = false;
                this.lessEffectiveTools = false;
                this.limitedBlueprintAccess = false;
                this.tradingEnabled = true;
                this.magicEnabled = true;
                this.faithEnabled = true;
                this.aliensEnabled = true;
                this.healingEnabled = true;
                this.surroundingCheckEnabled = true;
                break;
        }
    }

    public Integer advanceTurn() {
        Integer dateInc = 0;
        ArrayList<AbstractEncounter> encounters = EncounterManager.generateEncounters();
        if (encounters.size() > 0) {
            dateInc += gameManager.advanceDate(5, 15);
            for (AbstractEncounter enc : encounters) {
                if (village.canRunEncounter(enc)) {
                    Logger.getGlobal().info("\nRandom encounter!! Encounter: " + enc.toString() + "\n");
                    enc.runEncounter(village, gameBoard);
                } else {
                    Logger.getGlobal().info("\nSkipped encounter due to it being active already. Encounter: " + enc.toString() + "\n");
                }
            }
            int low = 25 - dateInc;
            int high = 45 - dateInc;
            if (low < 0) { low = 0; }
            if (high < 1) { high = 1; }
            dateInc += gameManager.advanceDate(low, high);
        } else {
            dateInc += gameManager.advanceDate(25, 45);
        }

        actionManager.update();

        Database.score(dateInc);
        gameManager.incTurns();
        return dateInc;
    }

    public void runActions() {
        while (!actionManager.actions.isEmpty() || !actionManager.preTurnActions.isEmpty() || !actionManager.postTurnActions.isEmpty()) {
            actionManager.update();
        }
        priorityManager.reset();
    }

    public void fillActionManagerWithSimpleActions() {
        for (int i = 0; i < priorityManager.getPray(); i++) {
            actionManager.addToBottom(new Praying(this));
        }

        for (int i = 0; i < priorityManager.getForage(); i++) {
            actionManager.addToBottom(new Foraging(this));
        }

        for (int i = 0; i < priorityManager.getWoodcut(); i++) {
            actionManager.addToBottom(new Woodcutting(this));
        }

        for (int i = 0; i < priorityManager.getStone(); i++) {
            actionManager.addToBottom(new StonePicking(this));
        }

        for (int i = 0; i < priorityManager.getMine(); i++) {
            actionManager.addToBottom(new Mining(this));
        }

        for (int i = 0; i < priorityManager.getDefend(); i++) {
            actionManager.addToBottom(new Defense(this));
        }

        for (int i = 0; i < priorityManager.getHarvest(); i++) {
            actionManager.addToBottom(new Harvesting(this));
        }

        for (int i = 0; i < priorityManager.getForge(); i++) {
            actionManager.addToBottom(new Forging(this));
        }

        for (int i = 0; i < priorityManager.getHeal(); i++) {
            actionManager.addToBottom(new Healing(this));
        }
    }

    public void newCitizen(Survivor s) {
        village.addToPopulation(s);
    }

    public Boolean newBuilding(AbstractBuilding b) {
        return village.addBuilding(b);
    }

    public void newMiracle(AbstractMiracle m) {
        village.addMiracle(m);
    }

    public void newDisaster(AbstractDisaster d) {
        village.addDisaster(d);
    }

    public void newPlague(AbstractPlague p) {
        village.addPlague(p);
    }

    public void newHostileRaid(AbstractRaid r) {
        village.addHostileRaid(r);
    }

    public void newFriendlyRaid(AbstractRaid r) {
        village.addFriendlyRaid(r);
    }

    public void banditEncounter(AbstractBandits encounter) {
        village.addBandits(encounter);
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public GameManager getGameManager() {
        return gameManager;
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

    public Boolean getSurroundingCheckEnabled() {
        return surroundingCheckEnabled;
    }

    public Race getPlayerRace() {
        return playerRace;
    }

    public Modes getDifficulty() {
        return difficulty;
    }

    public Village getVillage() {
        return village;
    }
}
