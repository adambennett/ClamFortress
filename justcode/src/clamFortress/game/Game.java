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
import clamFortress.models.gridSpaces.*;
import clamFortress.models.resources.natural.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Game {

    public static boolean isLoaded = false;

    // Nested Objects
    public  static ActionManager actionManager;
    public  static PriorityManager priorityManager;
    private static Board gameBoard;
    private static GameManager gameManager;

    // Difficulty Modifiers
    private static Boolean toughEnemies;
    private static Boolean hostileEnemies;
    private static Boolean slowResourceGain;
    private static Boolean frequentBadEvents;
    private static Boolean terribleDisasters;
    private static Boolean handicappedStartEquipment;
    private static Boolean moreNetherworlds;
    private static Boolean lessEffectiveTools;
    private static Boolean limitedBlueprintAccess;
    private static Boolean tradingEnabled;
    private static Boolean magicEnabled;
    private static Boolean aliensEnabled;
    private static Boolean healingEnabled;
    private static Boolean faithEnabled;
    private static Boolean surroundingCheckEnabled;
    private static Race playerRace;
    private static Modes difficulty;

    // Default Settings (for tests)
    public Game() {
        this(Modes.DEFAULT, Race.HUMAN, new Grasslands());
    }

    public Game(Modes gameDifficulty, Race chosenRace, AbstractRegion startingBiome) {
        difficulty = gameDifficulty;
        actionManager = new ActionManager();
        priorityManager = new PriorityManager();
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board(startingBiome, 50, 50);
        int highRoll = getVillage().getPopCap();
        int lowRoll = 1;
        if (highRoll < 2) { highRoll = 2; }
        int startingSurvivors = ThreadLocalRandom.current().nextInt(lowRoll, highRoll);
        new NewSurvivors().addToVillage(startingSurvivors);
        updateDifficultyBools();
        isLoaded = true;
    }

    // Custom Difficulty
    public Game(Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractRegion startingBiome) {
        difficulty = Modes.CUSTOM;
        actionManager = new ActionManager();
        priorityManager = new PriorityManager();        
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board(startingBiome, 50, 50);
        int highRoll = getVillage().getPopCap();
        int lowRoll = 1;
        if (highRoll < 2) { highRoll = 2; }

        lowRoll = 199;
        highRoll = 200;

        int startingSurvivors = ThreadLocalRandom.current().nextInt(lowRoll, highRoll);
        new NewSurvivors().addToVillage(startingSurvivors);
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
        isLoaded = true;
    }

    public static ArrayList<Flowers> generateRandomFlowers() {
        ArrayList<Flowers> flows = new ArrayList<>();
        // TODO: Add flowers based on difficulty
        return flows;
    }

    public Integer advanceTurn() {
        Integer dateInc = 0;
        ArrayList<AbstractEncounter> encounters = EncounterManager.generateEncounters();
        if (encounters.size() > 0) {
            dateInc += gameManager.advanceDate(5, 15);
            for (AbstractEncounter enc : encounters) {
                if (gameBoard.getVillage().canRunEncounter(enc)) {
                    Logger.getGlobal().info("\nRandom encounter!! Encounter: " + enc.toString() + "\n");
                    enc.runEncounter(gameBoard);
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
        actionManager.addToTurnStart(new NewSurvivors());

        for (int i = 0; i < priorityManager.getScout(); i++) {
            actionManager.addToTurnEnd(new Scouting(this));
        }

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
        gameBoard.getVillage().addToPopulation(s);
    }

    public Boolean newBuilding(AbstractBuilding b) {
        return gameBoard.getVillage().addBuilding(b);
    }

    public void newMiracle(AbstractMiracle m) {
        gameBoard.getVillage().addMiracle(m);
    }

    public void newDisaster(AbstractDisaster d) {
        gameBoard.getVillage().addDisaster(d);
    }

    public void newPlague(AbstractPlague p) {
        gameBoard.getVillage().addPlague(p);
    }

    public void newHostileRaid(AbstractRaid r) {
        gameBoard.getVillage().addHostileRaid(r);
    }

    public void newFriendlyRaid(AbstractRaid r) {
        gameBoard.getVillage().addFriendlyRaid(r);
    }

    public void banditEncounter(AbstractBandits encounter) {
        gameBoard.getVillage().addBandits(encounter);
    }

    public static Board getGameBoard() {
        return gameBoard;
    }

    public static GameManager getGameManager() {
        return gameManager;
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

    public static Boolean getSurroundingCheckEnabled() {
        return surroundingCheckEnabled;
    }

    public static Race getPlayerRace() {
        return playerRace;
    }

    public static Modes getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(Modes newDifficulty) {
        difficulty = newDifficulty;
        updateDifficultyBools();
    }
    
    public static Village getVillage() {
        return gameBoard.getVillage();
    }

    public static void updateDifficultyBools() {
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
}
