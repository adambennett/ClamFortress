package main.models.managers;


import main.models.*;

public class PriorityManager {

    private static Integer  pointsRemaining = 0;
    private static Integer  food1 = 0;
    private static Integer  food2 = 0;
    private static Integer  food3 = 0;
    private static Integer  pray = 0;
    private static Integer  forage = 0;
    private static Integer  woodcut = 0;
    private static Integer  stone = 0;
    private static Integer  mine = 0;
    private static Integer  defend = 0;
    private static Integer  harvest = 0;
    private static Integer  forge = 0;
    private static Integer  heal = 0;
    private static Integer  scout = 0;
    private static Integer  plant = 0;
    private static Integer  smith = 0;
    private static Integer masonry = 0;
    private static Integer  raid = 0;
    private static Integer  engineer = 0;
    private static Integer  build = 0;
    private static Integer  trade = 0;

    public static void reset(boolean resetPoints) {
        if (resetPoints) {
            pointsRemaining = 0;
        }
        food1 = 0;
        food2 = 0;
        food3 = 0;
        pray = 0;
        forage = 0;
        woodcut = 0;
        stone = 0;
        mine = 0;
        defend = 0;
        harvest = 0;
        forge = 0;
        heal = 0;
        scout = 0;
        plant = 0;
        smith = 0;
        masonry = 0;
        raid = 0;
        engineer = 0;
        build = 0;
        trade = 0;
    }

    public static Integer getPointsRemaining() {
        return pointsRemaining;
    }

    public static void setPointsRemaining(Integer pointsRemaining) {
        int orig = PriorityManager.getPointsRemaining();
        PriorityManager.pointsRemaining = pointsRemaining;
        int fin = PriorityManager.getPointsRemaining();
        int diff = fin - orig;
        for (GameObject obj : Game.getModifierObjects()) {
            obj.onSpendPriorityPoints(diff);
        }
    }

    public static Integer getFood1() {
        return food1;
    }

    public static void setFood1(Integer food1) {
        PriorityManager.food1 = food1;
    }

    public static Integer getFood2() {
        return food2;
    }

    public static void setFood2(Integer food2) {
        PriorityManager.food2 = food2;
    }

    public static Integer getFood3() {
        return food3;
    }

    public static void setFood3(Integer food3) {
        PriorityManager.food3 = food3;
    }

    public static Integer getPray() {
        return pray;
    }

    public static void setPray(Integer pray) {
        PriorityManager.pray = pray;
    }

    public static Integer getForage() {
        return forage;
    }

    public static void setForage(Integer forage) {
        PriorityManager.forage = forage;
    }

    public static Integer getWoodcut() {
        return woodcut;
    }

    public static void setWoodcut(Integer woodcut) {
        PriorityManager.woodcut = woodcut;
    }

    public static Integer getStone() {
        return stone;
    }

    public static void setStone(Integer stone) {
        PriorityManager.stone = stone;
    }

    public static Integer getMine() {
        return mine;
    }

    public static void setMine(Integer mine) {
        PriorityManager.mine = mine;
    }

    public static Integer getDefend() {
        return defend;
    }

    public static void setDefend(Integer defend) {
        PriorityManager.defend = defend;
    }

    public static Integer getHarvest() {
        return harvest;
    }

    public static void setHarvest(Integer harvest) {
        PriorityManager.harvest = harvest;
    }

    public static Integer getForge() {
        return forge;
    }

    public static void setForge(Integer forge) {
        PriorityManager.forge = forge;
    }

    public static Integer getHeal() {
        return heal;
    }

    public static void setHeal(Integer heal) {
        PriorityManager.heal = heal;
    }

    public static Integer getScout() {
        return scout;
    }

    public static void setScout(Integer scout) {
        PriorityManager.scout = scout;
    }

    public static Integer getPlant() {
        return plant;
    }

    public static void setPlant(Integer plant) {
        PriorityManager.plant = plant;
    }

    public static Integer getSmith() {
        return smith;
    }

    public static void setSmith(Integer smith) {
        PriorityManager.smith = smith;
    }

    public static Integer getMasonry() {
        return masonry;
    }

    public static void setMasonry(Integer masonry) {
        PriorityManager.masonry = masonry;
    }

    public static Integer getRaid() {
        return raid;
    }

    public static void setRaid(Integer raid) {
        PriorityManager.raid = raid;
    }

    public static Integer getEngineer() {
        return engineer;
    }

    public static void setEngineer(Integer engineer) {
        PriorityManager.engineer = engineer;
    }

    public static Integer getBuild() {
        return build;
    }

    public static void setBuild(Integer build) {
        PriorityManager.build = build;
    }

    public static Integer getTrade() {
        return trade;
    }

    public static void setTrade(Integer trade) {
        PriorityManager.trade = trade;
    }
}
