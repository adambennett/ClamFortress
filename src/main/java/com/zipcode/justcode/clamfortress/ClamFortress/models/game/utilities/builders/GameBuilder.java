package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

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
    private Era startingEra;


    public GameBuilder(){
        this.startingPop = 0;
        this.startingPopCap = 5;
        this.xMax = 15;
        this.yMax = 15;
        this.difficulty = Difficulty.DEFAULT;
        this.race = Race.HUMAN;
        this.customMods = new ArrayList<>();
        this.startBiome = new Grasslands();
    }

    public void reset() {
        this.startingPop = 0;
        this.startingPopCap = 5;
        this.xMax = 15;
        this.yMax = 15;
        this.difficulty = Difficulty.DEFAULT;
        this.race = Race.HUMAN;
        this.customMods = new ArrayList<>();
        this.startBiome = new Grasslands();
    }

    public Boolean buildGame() {
        if (this.difficulty.equals(Difficulty.RANDOM)) {
            this.difficulty = Difficulty.getRandomDifficulty();
        }
        Game game;
        if (this.difficulty.equals(Difficulty.CUSTOM)) {
            game = new Game(this.startingEra, this.race, this.customMods, this.startBiome, this.startingPopCap, this.xMax, this.yMax);
        } else {
            game = new Game(this.startingEra, this.difficulty, this.race, this.startBiome, this.startingPopCap, this.xMax, this.yMax);
        }
        if (!Database.getPlayer().getName().equals("Quickplayer")) {
            Database.registerGame(game);
        }
        game.postSetup(this.startingPop);
        return true;
    }

    public void setStartingEra(Era startingEra) {
        this.startingEra = startingEra;
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
        if (this.xMax > 125) {
            this.xMax = 125;
        }
    }

    public void setyMax(Integer yMax) {
        this.yMax = yMax;
        if (this.yMax > 125) {
            this.yMax = 125;
        }
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

    public Era getStartingEra() {
        return startingEra;
    }

    @Override
    public String toString() {
        String gameInfo = "";
        gameInfo += "\n\nGame Information:\n  Difficulty: " + difficulty.toString();
        gameInfo += "\n  Race: " + race.toString();
        gameInfo += "\n  Starting Biome: " + startBiome.toString();
        gameInfo += "\n  Starting Population: " + startingPop + " / " + startingPopCap;
        gameInfo += "\n  Board Size: " + xMax + "x" + yMax;
        if (this.startingEra != null) {
            gameInfo += "\n  Starting Era: " + this.startingEra.toString();
        } else {
            gameInfo += "\n  Starting Era: " + new BronzeAge().toString();
        }
        if (customMods.size() > 0) {
            gameInfo += "\n  All modifiers: ";
            Collections.sort(customMods);
            gameInfo += "\n";
            for (Integer i : customMods) { gameInfo += "    " + GameStrings.modifierMap.get(i) + "\n"; }
            gameInfo = gameInfo.substring(0, gameInfo.length() - 1);
        }
        gameInfo += "\n";
        return gameInfo;
    }
}
