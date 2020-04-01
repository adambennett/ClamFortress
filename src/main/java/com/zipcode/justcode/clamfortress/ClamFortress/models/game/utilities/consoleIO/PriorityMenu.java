package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.alien.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.claman.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.dwarf.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.elf.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.human.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.food.orc.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class PriorityMenu extends AbstractConsole {

    public PriorityMenu() { super(); }

    @Override
    public void initializeCommands() {
        int newPoints = 0;//PriorityManager.getPointsRemaining() + (Database.getCurrentGame().getVillage().getPopulation().size() * Database.getCurrentGame().getDifficulty().getPriorityMod());
        for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
            newPoints += obj.modifyPriorityPoints();
        }
        PriorityManager.setPointsRemaining(newPoints);
        consoleCommands.put("1", MenuCommands.DYNAMIC_FOOD_A);
        consoleCommands.put("2", MenuCommands.DYNAMIC_FOOD_B);
        consoleCommands.put("3", MenuCommands.DYNAMIC_FOOD_C);
        consoleCommands.put("4", MenuCommands.PRAY);
        consoleCommands.put("5", MenuCommands.FORAGE);
        consoleCommands.put("6", MenuCommands.WOODCUTTING);
        consoleCommands.put("7", MenuCommands.STONE_PICK);
        consoleCommands.put("8", MenuCommands.MINING);
        consoleCommands.put("9", MenuCommands.DEFENDING);
        consoleCommands.put("10", MenuCommands.HARVESTING);
        consoleCommands.put("11", MenuCommands.FORGING);
        consoleCommands.put("12", MenuCommands.HEALING);
        consoleCommands.put("13", MenuCommands.SCOUTING);
        consoleCommands.put("14", MenuCommands.PLANTING);
        consoleCommands.put("15", MenuCommands.SMITHING);
        consoleCommands.put("16", MenuCommands.SMELTING);
        consoleCommands.put("17", MenuCommands.RAIDING);
        consoleCommands.put("18", MenuCommands.ENGINEERING);
        consoleCommands.put("19", MenuCommands.BUILDING);
        consoleCommands.put("20", MenuCommands.TRADING);
        consoleCommands.put("21", MenuCommands.MASONRY);
        consoleCommands.put("22", MenuCommands.STORING);
        consoleCommands.put("0", MenuCommands.CONTINUE);

        consoleCommands.put("hunt", MenuCommands.DYNAMIC_FOOD_A);
        consoleCommands.put("fish", MenuCommands.DYNAMIC_FOOD_B);
        consoleCommands.put("cook", MenuCommands.DYNAMIC_FOOD_C);
        consoleCommands.put("smelt", MenuCommands.SMELTING);
        consoleCommands.put("smelting", MenuCommands.SMELTING);
        consoleCommands.put("continue", MenuCommands.CONTINUE);
        consoleCommands.put("next", MenuCommands.CONTINUE);
        consoleCommands.put("end", MenuCommands.CONTINUE);
        consoleCommands.put("pray", MenuCommands.PRAY);
        consoleCommands.put("forage", MenuCommands.FORAGE);
        consoleCommands.put("wood", MenuCommands.WOODCUTTING);
        consoleCommands.put("woodcutting", MenuCommands.WOODCUTTING);
        consoleCommands.put("stone", MenuCommands.STONE_PICK);
        consoleCommands.put("mine", MenuCommands.MINING);
        consoleCommands.put("mining", MenuCommands.MINING);
        consoleCommands.put("defending", MenuCommands.DEFENDING);
        consoleCommands.put("defend", MenuCommands.DEFENDING);
        consoleCommands.put("def", MenuCommands.DEFENDING);
        consoleCommands.put("harvesting", MenuCommands.HARVESTING);
        consoleCommands.put("harvest", MenuCommands.HARVESTING);
        consoleCommands.put("forge", MenuCommands.FORGING);
        consoleCommands.put("healing", MenuCommands.HEALING);
        consoleCommands.put("heal", MenuCommands.HEALING);
        consoleCommands.put("scouting", MenuCommands.SCOUTING);
        consoleCommands.put("scout", MenuCommands.SCOUTING);
        consoleCommands.put("explore", MenuCommands.SCOUTING);
        consoleCommands.put("exploring", MenuCommands.SCOUTING);
        consoleCommands.put("discover", MenuCommands.SCOUTING);
        consoleCommands.put("planting", MenuCommands.PLANTING);
        consoleCommands.put("plant", MenuCommands.PLANTING);
        consoleCommands.put("smithing", MenuCommands.SMITHING);
        consoleCommands.put("smith", MenuCommands.SMITHING);
        consoleCommands.put("masonry", MenuCommands.MASONRY);
        consoleCommands.put("mason", MenuCommands.MASONRY);
        consoleCommands.put("raid", MenuCommands.RAIDING);
        consoleCommands.put("raiding", MenuCommands.RAIDING);
        consoleCommands.put("engineering", MenuCommands.ENGINEERING);
        consoleCommands.put("engineer", MenuCommands.ENGINEERING);
        consoleCommands.put("eng", MenuCommands.ENGINEERING);
        consoleCommands.put("build", MenuCommands.BUILDING);
        consoleCommands.put("building", MenuCommands.BUILDING);
        consoleCommands.put("trade", MenuCommands.TRADING);
        consoleCommands.put("trading", MenuCommands.TRADING);
        consoleCommands.put("store", MenuCommands.STORING);
        consoleCommands.put("storing", MenuCommands.STORING);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        Integer amt = 0;
        if (args.size() > 0) {
        try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) { }}
        if (amt > PriorityManager.getPointsRemaining()) {
            amt = PriorityManager.getPointsRemaining();
        }
        ActionManager actionManager = Database.getCurrentGame().actionManager;
        ArrayList<AbstractGameAction> foodActions = getFoodActions(amt);
        switch(cmd) {
            case CONTINUE:
                Database.getCurrentGame().advanceTurn();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case DYNAMIC_FOOD_A:
                PriorityManager.setFood1(PriorityManager.getFood1() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    Database.getCurrentGame().actionManager.addToBottom(foodActions.get(0).clone());
                    for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case DYNAMIC_FOOD_B:
                PriorityManager.setFood2(PriorityManager.getFood2() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(foodActions.get(1).clone());
                    for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case DYNAMIC_FOOD_C:
                PriorityManager.setFood3(PriorityManager.getFood3() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(foodActions.get(2).clone());
                    for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case PRAY:
                PriorityManager.setPray(PriorityManager.getPray() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Praying(amt));
                break;
            case FORAGE:
                PriorityManager.setForage(PriorityManager.getForage() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Foraging(amt));
                break;
            case WOODCUTTING:
                PriorityManager.setWoodcut(PriorityManager.getWoodcut() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Woodcutting(amt));
                break;
            case STONE_PICK:
                PriorityManager.setStone(PriorityManager.getStone() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new RockPicking(amt));
                break;
            case MINING:
                PriorityManager.setMine(PriorityManager.getMine() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Mining(amt));
                break;
            case DEFENDING:
                PriorityManager.setDefend(PriorityManager.getDefend() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Defense(amt));
                break;
            case HARVESTING:
                PriorityManager.setHarvest(PriorityManager.getHarvest() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Harvesting(amt));
                break;
            case FORGING:
                PriorityManager.setForge(PriorityManager.getForge() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Forging(amt));
                break;
            case HEALING:
                PriorityManager.setHeal(PriorityManager.getHeal() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Healing(amt));
                break;
            case SCOUTING:
                PriorityManager.setScout(PriorityManager.getScout() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Scouting(amt, Database.getCurrentGame().gameManager.getNethermod()));
                break;
            case PLANTING:
                PriorityManager.setPlant(PriorityManager.getPlant() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Planting(amt));
                break;
            case SMELTING:
                PriorityManager.setSmelt(PriorityManager.getSmelt() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Smelting(amt));
                break;
            case MASONRY:
                PriorityManager.setMasonry(PriorityManager.getMasonry() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Masonry(amt));
                break;
            case RAIDING:
                PriorityManager.setRaid(PriorityManager.getRaid() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                if (Database.getCurrentGame().gameManager.getRaidingCity() != null) {
                    actionManager.addToTurnEnd(new Raiding(Database.getCurrentGame().gameManager.getRaidingCity(), amt));
                } else {
                    OutputManager.addToBot(OutputFlag.NO_RAIDS, "No city currently selected for raiding! Choose option 8 from the Standby Phase menu to select a city to raid.");
                }
                break;
            case ENGINEERING:
                PriorityManager.setEngineer(PriorityManager.getEngineer() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case BUILDING:
                PriorityManager.setBuild(PriorityManager.getBuild() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case TRADING:
                PriorityManager.setTrade(PriorityManager.getTrade() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Trading(amt));
                break;
            case STORING:
                PriorityManager.setStore(PriorityManager.getStore() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Storing(amt));
                break;
            case SMITHING:
                PriorityManager.setSmith(PriorityManager.getSmith() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                actionManager.addToBottom(new Smithing(amt));
        }
    }

    public static ArrayList<AbstractGameAction> getFoodActions(int amt) {
        ArrayList<AbstractGameAction> foodActions = new ArrayList<>();
        if (Database.getCurrentGame().getPlayerRace().equals(Race.HUMAN)) {
            foodActions.add(new Hunting(amt));
            foodActions.add(new Fishing(amt));
            foodActions.add(new Cooking(amt));
        } else if (Database.getCurrentGame().getPlayerRace().equals(Race.ORC)) {
            foodActions.add(new OrcFoodRaid(amt));
            foodActions.add(new OrcHunting(amt));
            foodActions.add(new Sacrifice(amt));
        } else if (Database.getCurrentGame().getPlayerRace().equals(Race.ELF)) {
            foodActions.add(new InsectHunt(amt));
            foodActions.add(new RiverSearch(amt));
            foodActions.add(new Roasting(amt));
        } else if (Database.getCurrentGame().getPlayerRace().equals(Race.DWARF)) {
            foodActions.add(new Brewing(amt));
            foodActions.add(new MushroomPicking(amt));
            foodActions.add(new Scavenging(amt));
        } else if (Database.getCurrentGame().getPlayerRace().equals(Race.CLAMAN)) {
            foodActions.add(new Angling(amt));
            foodActions.add(new Diving(amt));
            foodActions.add(new Trawling(amt));
        } else if (Database.getCurrentGame().getPlayerRace().equals(Race.ALIEN)) {
            foodActions.add(new Abducting(amt));
            foodActions.add(new Analyzing(amt));
            foodActions.add(new Redacted(amt));
        }
        return foodActions;
    }

    @Override
    protected void postMultiline() {
        printPrompt(PromptMessage.PRIORITY_MENU, true, true);
    }
}
