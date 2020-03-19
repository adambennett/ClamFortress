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
    private Integer startingPopCap;
    private Integer startingPop;
    private Integer xMax;
    private Integer yMax;


    public GameBuilder(){
        this.startingPop = 0;
        this.startingPopCap = 5;
        this.xMax = 50;
        this.yMax = 50;
        this.difficulty = Difficulty.DEFAULT;
        this.race = Race.HUMAN;
        this.customMods = new ArrayList<>();
        this.startBiome = new Grasslands();
    }

    public Boolean buildGame() {
        try {
            if (this.difficulty.equals(Difficulty.RANDOM)) {
                this.difficulty = Difficulty.getRandomDifficulty();
            }
            if (this.difficulty.equals(Difficulty.CUSTOM)) {
                Game.startGame(this.race, this.customMods, this.startBiome, this.startingPop, this.startingPopCap, this.xMax, this.yMax);
            } else {
                Game.startGame(this.difficulty, this.race, this.startBiome, this.startingPop, this.startingPopCap, this.xMax, this.yMax);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
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

    public void setStartingPopCap(Integer startingPopCap) {
        this.startingPopCap = startingPopCap;
    }

    public void setStartingPop(Integer startingPop) {
        this.startingPop = startingPop;
    }

    public void setxMax(Integer xMax) {
        this.xMax = xMax;
    }

    public void setyMax(Integer yMax) {
        this.yMax = yMax;
    }

    public Integer getxMax() {
        return xMax;
    }

    public Integer getyMax() {
        return yMax;
    }

    public Integer getStartingPopCap() {
        return startingPopCap;
    }

    public Integer getStartingPop() {
        return startingPop;
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
