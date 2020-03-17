package main.utilities.builders;

import main.enums.*;
import main.game.*;
import main.game.regions.*;

import java.util.*;

public class GameBuilder {

    private Difficulty difficulty;
    private Race race;
    private ArrayList<Integer> customMods;
    private AbstractRegion startBiome;

    public GameBuilder(){
        this.difficulty = Difficulty.DEFAULT;
        this.race = Race.HUMAN;
        this.customMods = new ArrayList<>();
        this.startBiome = new Grasslands();
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public void setCustomMods(ArrayList<Integer> customMods) {
        this.customMods = customMods;
    }

    public void setStartBiome(AbstractRegion startBiome) {
        this.startBiome = startBiome;
    }

    public Game buildGame() {
        if (this.difficulty.equals(Difficulty.RANDOM)) {
            this.difficulty = Difficulty.getRandomMode();
        }
        if (this.difficulty.equals(Difficulty.CUSTOM)) {
            return new Game(this.race, this.customMods, this.startBiome);
        } else {
            return new Game(this.difficulty, this.race, this.startBiome);
        }
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Race getRace() {
        return race;
    }

    public ArrayList<Integer> getCustomMods() {
        return customMods;
    }

    public AbstractRegion getStartBiome() {
        return startBiome;
    }
}
