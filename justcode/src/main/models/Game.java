package main.models;

import main.actions.priority.*;
import main.actions.utility.*;
import main.encounters.*;
import main.enums.*;
import main.models.buildings.abstracts.*;
import main.models.nodes.biomes.*;
import main.models.animals.*;
import main.models.animals.sea.*;
import main.models.nodes.*;
import main.models.managers.*;
import main.models.resources.natural.*;
import main.models.tech.*;
import main.models.tech.eras.*;
import main.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

public class Game {

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
    private static Difficulty difficulty;

    // Default Settings (for tests)
    public static void startGame() {
        startGame(new BronzeAge(true), Difficulty.DEFAULT, Race.HUMAN, new Grasslands(), 0, 5, 50, 50);
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
        gameBoard.discover(getVillage().getBaseNode());
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
        gameBoard.discover(getVillage().getBaseNode());
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
        ArrayList<GameObject> mods = new ArrayList<>();
        mods.addAll(getVillage().getAllResources());
        mods.addAll(getVillage().getInventory().getItems());
        mods.addAll(getVillage().getBuildings());
        mods.addAll(getGameBoard().getAnimals());
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
        Database.score(dateInc);
        gameManager.incTurns();
        queueEvergreenActions(dateInc);
        // complicated actions logic
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

}
