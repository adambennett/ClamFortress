package clamFortress.game.logic;

import clamFortress.actions.*;
import clamFortress.enums.*;
import clamFortress.game.*;
import clamFortress.game.regions.*;
import clamFortress.models.resources.refined.*;

import javax.swing.*;
import java.util.*;
import java.util.concurrent.*;

public class PriorityManager {

    private Integer pointsRemaining = 0;
    private Integer food1 = 0;
    private Integer food2 = 0;
    private Integer food3 = 0;
    private Integer pray = 0;
    private Integer forage = 0;
    private Integer woodcut = 0;
    private Integer stone = 0;
    private Integer mine = 0;
    private Integer defend = 0;
    private Integer harvest = 0;
    private Integer forge = 0;
    private Integer heal = 0;
    private Integer scout = 0;
    private Integer plant = 0;
    private Integer smith = 0;
    private Integer smelt = 0;
    private Integer raid = 0;
    private Integer engineer = 0;
    private Integer build = 0;
    private Integer trade = 0;
    private final Race chosenRace;
    private final ActionManager actionManager;
    private final Game game;
    
    public PriorityManager(Game game) {
        if (game != null) {
            this.chosenRace = null;
            this.pointsRemaining = 5;
            this.actionManager = new ActionManager();
        } else {
            this.chosenRace = game.getPlayerRace();
           // this.pointsRemaining = game.getVillage().getSurvivors().size();
            this.pointsRemaining = 200;
            this.actionManager = game.actionManager;
        }
        this.game = game;
    }

    public void runSimplePriorityLogic() {
        for (int i = 0; i < pray; i++) {
            actionManager.addToBottom(new Praying(game));
        }

        for (int i = 0; i < forage; i++) {
            actionManager.addToBottom(new Foraging(game));
        }

        for (int i = 0; i < woodcut; i++) {
            actionManager.addToBottom(new Woodcutting(game));
        }

        for (int i = 0; i < stone; i++) {
            actionManager.addToBottom(new StonePicking(game));
        }

        for (int i = 0; i < mine; i++) {
            actionManager.addToBottom(new Mining(game));
        }

        for (int i = 0; i < defend; i++) {
            actionManager.addToBottom(new Defense(game));
        }

        for (int i = 0; i < harvest; i++) {
            actionManager.addToBottom(new Harvesting(game));
        }

        for (int i = 0; i < forge; i++) {
            actionManager.addToBottom(new Forging(game));
        }

        for (int i = 0; i < heal; i++) {
            actionManager.addToBottom(new Healing(game));
        }
    }

    public Integer getPointsRemaining() {
        return pointsRemaining;
    }

    public void setPointsRemaining(Integer pointsRemaining) {
        this.pointsRemaining = pointsRemaining;
    }

    public ArrayList<AbstractGameAction> getActionsByPriorities() {
        return null;
    }

    private Integer getRoll(Integer priority) {
        return (priority < 1) ? 0 : ThreadLocalRandom.current().nextInt(0, priority);
    }

    public Integer getFood1() {
        return food1;
    }

    public void setFood1(Integer food1) {
        this.food1 = food1;
    }

    public Integer getFood2() {
        return food2;
    }

    public void setFood2(Integer food2) {
        this.food2 = food2;
    }

    public Integer getFood3() {
        return food3;
    }

    public void setFood3(Integer food3) {
        this.food3 = food3;
    }

    public Integer getPray() {
        return pray;
    }

    public void setPray(Integer pray) {
        this.pray = pray;
    }

    public Integer getForage() {
        return forage;
    }

    public void setForage(Integer forage) {
        this.forage = forage;
    }

    public Integer getWoodcut() {
        return woodcut;
    }

    public void setWoodcut(Integer woodcut) {
        this.woodcut = woodcut;
    }

    public Integer getStone() {
        return stone;
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public Integer getMine() {
        return mine;
    }

    public void setMine(Integer mine) {
        this.mine = mine;
    }

    public Integer getDefend() {
        return defend;
    }

    public void setDefend(Integer defend) {
        this.defend = defend;
    }

    public Integer getHarvest() {
        return harvest;
    }

    public void setHarvest(Integer harvest) {
        this.harvest = harvest;
    }

    public Integer getForge() {
        return forge;
    }

    public void setForge(Integer forge) {
        this.forge = forge;
    }

    public Integer getHeal() {
        return heal;
    }

    public void setHeal(Integer heal) {
        this.heal = heal;
    }

    public Integer getScout() {
        return scout;
    }

    public void setScout(Integer scout) {
        this.scout = scout;
    }

    public Integer getPlant() {
        return plant;
    }

    public void setPlant(Integer plant) {
        this.plant = plant;
    }

    public Integer getSmith() {
        return smith;
    }

    public void setSmith(Integer smith) {
        this.smith = smith;
    }

    public Integer getSmelt() {
        return smelt;
    }

    public void setSmelt(Integer smelt) {
        this.smelt = smelt;
    }

    public Integer getRaid() {
        return raid;
    }

    public void setRaid(Integer raid) {
        this.raid = raid;
    }

    public Integer getEngineer() {
        return engineer;
    }

    public void setEngineer(Integer engineer) {
        this.engineer = engineer;
    }

    public Integer getBuild() {
        return build;
    }

    public void setBuild(Integer build) {
        this.build = build;
    }

    public Integer getTrade() {
        return trade;
    }

    public void setTrade(Integer trade) {
        this.trade = trade;
    }

    public Race getChosenRace() {
        return chosenRace;
    }
}
