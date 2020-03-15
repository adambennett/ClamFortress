package clamFortress.game;

import clamFortress.enums.*;
import clamFortress.game.logic.*;
import clamFortress.game.regions.*;
import clamFortress.models.*;

import java.util.*;

public class Game {

    private final NewBoard gameBoard;
    private final GameManager gameManager;
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
        this.difficulty = Modes.CUSTOM;
        this.playerRace = chosenRace;
        this.gameManager = GameManager.getInstance();
        this.gameManager.incPopCap(5);
        this.gameManager.incPop(5);
        this.gameManager.incWood(100);
        this.gameBoard = new NewBoard(startingBiome);
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
        this.difficulty = gameDifficulty;
        this.playerRace = chosenRace;
        this.gameManager = GameManager.getInstance();
        this.gameManager.incPopCap(5);
        this.gameManager.incPop(5);
        this.gameManager.incWood(100);
        this.gameBoard = new NewBoard(startingBiome);
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

    public NewBoard getGameBoard() {
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
}
