package clamFortress.game;

import clamFortress.actions.*;
import clamFortress.consoleIO.*;
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
import clamFortress.tech.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Game {

    public static boolean isLoaded = false;

    // Nested Objects
    public  static ActionManager actionManager;
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
        TechTree.resetTechTree();
        PriorityManager.reset(true);
        difficulty = gameDifficulty;
        actionManager = new ActionManager();
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board(startingBiome, 50, 50);
        int startingSurvivors = ThreadLocalRandom.current().nextInt(0, 5);
        new NewSurvivors().addToVillage(startingSurvivors);
        updateDifficultyBools();
        isLoaded = true;
    }

    // Custom Difficulty
    public Game(Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractRegion startingBiome) {
        TechTree.resetTechTree();
        PriorityManager.reset(true);
        difficulty = Modes.CUSTOM;
        actionManager = new ActionManager();
        playerRace = chosenRace;
        gameManager = GameManager.getInstance();
        gameBoard = new Board(startingBiome, 50, 50);
        int startingSurvivors = ThreadLocalRandom.current().nextInt(0, 5);
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

    public static Integer advanceTurn() {
        Integer dateInc = 0;
        ArrayList<AbstractEncounter> encounters = EncounterManager.generateEncounters();
        if (encounters.size() > 0) {
            dateInc += gameManager.advanceDate(5, 15);
            for (AbstractEncounter enc : encounters) {
                if (gameBoard.getVillage().canRunEncounter(enc)) {
                    Logger.getGlobal().info("\nRandom encounter!! Encounter: " + enc.toString() + "\n");
                    enc.runEncounter();
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

    public static void runActions() {
        while (!actionManager.actions.isEmpty() || !actionManager.preTurnActions.isEmpty() || !actionManager.postTurnActions.isEmpty()) {
            actionManager.update();
        }
        PriorityManager.reset(difficulty.compareTo(Modes.HARD) > 0);
    }

    public static void fillActionManagerWithSimpleActions() {
        actionManager.addToTurnStart(new NewSurvivors());
        actionManager.addToTurnEnd(new EndPhaseHunger());

        for (int i = 0; i < PriorityManager.getScout(); i++) {
            actionManager.addToTurnEnd(new Scouting());
        }

        for (int i = 0; i < PriorityManager.getPray(); i++) {
            actionManager.addToBottom(new Praying());
        }

        for (int i = 0; i < PriorityManager.getForage(); i++) {
            actionManager.addToBottom(new Foraging());
        }

        for (int i = 0; i < PriorityManager.getWoodcut(); i++) {
            actionManager.addToBottom(new Woodcutting());
        }

        for (int i = 0; i < PriorityManager.getStone(); i++) {
            actionManager.addToBottom(new StonePicking());
        }

        for (int i = 0; i < PriorityManager.getMine(); i++) {
            actionManager.addToBottom(new Mining());
        }

        for (int i = 0; i < PriorityManager.getDefend(); i++) {
            actionManager.addToBottom(new Defense());
        }

        for (int i = 0; i < PriorityManager.getHarvest(); i++) {
            actionManager.addToBottom(new Harvesting());
        }

        for (int i = 0; i < PriorityManager.getForge(); i++) {
            actionManager.addToBottom(new Forging());
        }

        for (int i = 0; i < PriorityManager.getHeal(); i++) {
            actionManager.addToBottom(new Healing());
        }

        // TODO: Add hunger subtract survivors action to end of turn queue
        // hunger should be calculated: each survivor tries to eat 1 food
        // gain 1% hunger for each survivor that cant
        // max 100% hunger, certain thresholds should apply more punishing behavior

        // make new end phase manager that holds all strings to print at end of turn
        // just print them normally, dont format
        // replace EndMenu console with that manager
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

    public static void setDifficulty(Modes newDifficulty) {
        difficulty = newDifficulty;
        updateDifficultyBools();
    }

    public static Modes getDifficulty() {
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
}
