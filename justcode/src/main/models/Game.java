package main.models;

import main.actions.*;
import main.actions.priority.*;
import main.actions.priority.food.alien.*;
import main.actions.priority.food.claman.*;
import main.actions.priority.food.dwarf.*;
import main.actions.priority.food.elf.*;
import main.actions.priority.food.human.*;
import main.actions.priority.food.orc.*;
import main.actions.utility.*;
import main.encounters.*;
import main.enums.*;
import main.models.buildings.abstracts.*;
import main.models.items.*;
import main.models.nodes.biomes.*;
import main.models.animals.*;
import main.models.animals.sea.*;
import main.models.nodes.*;
import main.models.managers.*;
import main.models.resources.natural.*;
import main.models.tech.*;
import main.utilities.persistence.*;

import java.util.*;
import java.util.concurrent.*;

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
    private static Difficulty difficulty;

    // Default Settings (for tests)
    public static void startGame() {
        startGame(Difficulty.DEFAULT, Race.HUMAN, new Grasslands());
    }

    public static void startGame(Difficulty gameDifficulty, Race chosenRace, AbstractBiome startingBiome) {
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
    public static void startGame(Race chosenRace, ArrayList<Integer> customDifficultyMods, AbstractBiome startingBiome) {
        TechTree.resetTechTree();
        PriorityManager.reset(true);
        difficulty = Difficulty.CUSTOM;
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

    public static ArrayList<Flowers> generateRandomFlowers(AbstractBiome biome) {
        ArrayList<Flowers> flows = new ArrayList<>();
        // TODO: Add flowers based on difficulty & biome
        return flows;
    }

    public static ArrayList<AbstractAnimal> generateRandomAnimals(AbstractBiome biome) {
        ArrayList<AbstractAnimal> flows = new ArrayList<>();
        // TODO: Add animals based on difficulty & biome
        return flows;
    }


    public static ArrayList<AbstractSeaAnimal> generateRandomAquatic() {
        ArrayList<AbstractSeaAnimal> flows = new ArrayList<>();
        // TODO: Add sea life based on difficulty
        return flows;
    }

    public static void handleEncounter(AbstractEncounter enc) {
        if (gameBoard.getVillage().canRunEncounter(enc)) {
            OutputManager.addToBot("SPECIAL ENCOUNTER :: " + enc.toString());
            enc.runEncounter();
            for (AbstractItem item : getVillage().getInventory().getItems()) {
                item.onRunSpecialEncounter(enc);
            }
        }
    }

    public static Integer encounterLogic(ArrayList<AbstractEncounter> encounters) {
        Integer dateInc = gameManager.advanceDate(5, 15);
        for (AbstractEncounter enc : encounters) {
            handleEncounter(enc);
        }
        int highEnd = 45;
        for (AbstractItem item : getVillage().getInventory().getItems()) {
            highEnd += item.modifyDateIncrease();
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
            for (AbstractItem item : getVillage().getInventory().getItems()) {
                highEnd += item.modifyDateIncrease();
            }
            if (highEnd < 45) { highEnd = 45; }
            dateInc += gameManager.advanceDate(25, highEnd);
        }
        return dateInc;
    }

    public static void advanceTurn() {
        Integer dateInc = getDateInc();
        for (AbstractItem item : getVillage().getInventory().getItems()) {
            item.onDateAdvance(dateInc);
        }
        Database.score(dateInc);
        gameManager.incTurns();
        fillActionManagerWithSimpleActions(dateInc);
        // complicated actions logic
        runActions();
        PriorityManager.reset(difficulty.compareTo(Difficulty.HARD) > 0);
        for (AbstractItem item : getVillage().getInventory().getItems()) {
            item.endPhase();
        }
    }

    public static void runActions() {
        while (!actionManager.actions.isEmpty() || !actionManager.preTurnActions.isEmpty() || !actionManager.postTurnActions.isEmpty() || (actionManager.finalAction != null && !actionManager.finalAction.isDone)) {
            actionManager.update();
        }
    }

    public static ArrayList<AbstractGameAction> getFoodActions() {
        ArrayList<AbstractGameAction> foodActions = new ArrayList<>();
        if (Game.getPlayerRace().equals(Race.HUMAN)) {
            foodActions.add(new Hunting());
            foodActions.add(new Fishing());
            foodActions.add(new Cooking());
        } else if (Game.getPlayerRace().equals(Race.ORC)) {
            foodActions.add(new OrcFoodRaid());
            foodActions.add(new OrcHunting());
            foodActions.add(new Sacrifice());
        } else if (Game.getPlayerRace().equals(Race.ELF)) {
            foodActions.add(new InsectHunt());
            foodActions.add(new RiverSearch());
            foodActions.add(new Roasting());
        } else if (Game.getPlayerRace().equals(Race.DWARF)) {
            foodActions.add(new Brewing());
            foodActions.add(new MushroomPicking());
            foodActions.add(new Scavenging());
        } else if (Game.getPlayerRace().equals(Race.CLAMAN)) {
            foodActions.add(new Angling());
            foodActions.add(new Diving());
            foodActions.add(new Trawling());
        } else if (Game.getPlayerRace().equals(Race.ALIEN)) {
            foodActions.add(new Abducting());
            foodActions.add(new Analyzing());
            foodActions.add(new Redacted());
        }
        return foodActions;
    }

    public static Integer fillActionManagerWithSimpleActions(int dateInc) {
        int totalActions = 2;
        actionManager.addToTurnStart(new NewSurvivors());
        actionManager.addToTurnEnd(new EndPhaseHunger());

        ArrayList<AbstractGameAction> foodActions = getFoodActions();
        for (int i = 0; i < PriorityManager.getFood1(); i++) {
            actionManager.addToBottom(foodActions.get(0).clone());
            for (AbstractItem item : getVillage().getInventory().getItems()) {
                item.onGatherFood(foodActions.get(0));
            }
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getFood2(); i++) {
            actionManager.addToBottom(foodActions.get(1).clone());
            for (AbstractItem item : getVillage().getInventory().getItems()) {
                item.onGatherFood(foodActions.get(1));
            }
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getFood3(); i++) {
            actionManager.addToBottom(foodActions.get(2).clone());
            for (AbstractItem item : getVillage().getInventory().getItems()) {
                item.onGatherFood(foodActions.get(2));
            }
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getScout(); i++) {
            actionManager.addToTurnEnd(new Scouting());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getPray(); i++) {
            actionManager.addToBottom(new Praying());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getForage(); i++) {
            actionManager.addToBottom(new Foraging());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getWoodcut(); i++) {
            actionManager.addToBottom(new Woodcutting());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getStone(); i++) {
            actionManager.addToBottom(new RockPicking());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getMine(); i++) {
            actionManager.addToBottom(new Mining());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getDefend(); i++) {
            actionManager.addToBottom(new Defense());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getHarvest(); i++) {
            actionManager.addToBottom(new Harvesting());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getForge(); i++) {
            actionManager.addToBottom(new Forging());
            totalActions++;
        }

        for (int i = 0; i < PriorityManager.getHeal(); i++) {
            actionManager.addToBottom(new Healing());
            totalActions++;
        }

        if (getVillage().getUncompletedBuildings().size() > 0) {
            for (int i = 0; i < PriorityManager.getBuild(); i++) {
                int randIndex = ThreadLocalRandom.current().nextInt(getVillage().getUncompletedBuildings().size());
                AbstractBuilding rand = getVillage().getUncompletedBuildings().get(randIndex);
                actionManager.addToBottom(new Building(rand));
                totalActions++;
            }
        }

        for (int i = 0; i < PriorityManager.getEngineer(); i++) {
            actionManager.addToBottom(new Engineering(BuildingManager.getRandomBuilding()));
            totalActions++;
        }

        actionManager.setAbsoluteLastAction(new EndTurnReport(dateInc, totalActions));
        return totalActions;
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
