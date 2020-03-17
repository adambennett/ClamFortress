package main.utilities.builders;

import main.enums.*;
import main.models.*;
import main.models.nodes.biomes.*;

import java.util.*;

public class GameBuilder {

    private Difficulty difficulty;
    private Race race;
    private ArrayList<Integer> customMods;
    private AbstractBiome startBiome;

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

    public void setStartBiome(AbstractBiome startBiome) {
        this.startBiome = startBiome;
    }

    public Boolean buildGame() {
        try {
            if (this.difficulty.equals(Difficulty.RANDOM)) {
                this.difficulty = Difficulty.getRandomDifficulty();
            }
            if (this.difficulty.equals(Difficulty.CUSTOM)) {
                Game.startGame(this.race, this.customMods, this.startBiome);
            } else {
                Game.startGame(this.difficulty, this.race, this.startBiome);
            }
            return true;
        } catch (Exception ex) {
            return false;
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

    public AbstractBiome getStartBiome() {
        return startBiome;
    }
}
