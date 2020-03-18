package main.utilities.consoleIO;

import main.actions.*;
import main.actions.priority.*;
import main.actions.priority.food.alien.*;
import main.actions.priority.food.claman.*;
import main.actions.priority.food.dwarf.*;
import main.actions.priority.food.elf.*;
import main.actions.priority.food.human.*;
import main.actions.priority.food.orc.*;
import main.enums.*;
import main.models.*;
import main.models.items.*;
import main.models.managers.*;

import java.util.*;

public class PriorityMenu extends AbstractConsole {

    public PriorityMenu() { super(); }

    @Override
    protected void initializeCommands() {
        int newPoints = PriorityManager.getPointsRemaining() + (Game.getVillage().getPopulation() * Game.getDifficulty().getPriorityMod());
        for (GameObject obj : Game.getModifierObjects()) {
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
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        Integer amt = 0;
        if (args.size() > 0) {
        try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) { }}
        if (amt > PriorityManager.getPointsRemaining()) {
            amt = PriorityManager.getPointsRemaining();
        }
        ActionManager actionManager = Game.actionManager;
        ArrayList<AbstractGameAction> foodActions = getFoodActions();
        switch(cmd) {
            case CONTINUE:
                Game.advanceTurn();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case DYNAMIC_FOOD_A:
                PriorityManager.setFood1(PriorityManager.getFood1() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    Game.actionManager.addToBottom(foodActions.get(0).clone());
                    for (GameObject obj : Game.getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case DYNAMIC_FOOD_B:
                PriorityManager.setFood2(PriorityManager.getFood2() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(foodActions.get(1).clone());
                    for (GameObject obj : Game.getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case DYNAMIC_FOOD_C:
                PriorityManager.setFood3(PriorityManager.getFood3() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(foodActions.get(2).clone());
                    for (GameObject obj : Game.getModifierObjects()) {
                        obj.onGatherFood(foodActions.get(0));
                    }
                }
                break;
            case PRAY:
                PriorityManager.setPray(PriorityManager.getPray() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Praying());
                }
                break;
            case FORAGE:
                PriorityManager.setForage(PriorityManager.getForage() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Foraging());
                }
                break;
            case WOODCUTTING:
                PriorityManager.setWoodcut(PriorityManager.getWoodcut() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Woodcutting());
                }
                break;
            case STONE_PICK:
                PriorityManager.setStone(PriorityManager.getStone() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new RockPicking());
                }
                break;
            case MINING:
                PriorityManager.setMine(PriorityManager.getMine() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Mining());
                }
                break;
            case DEFENDING:
                PriorityManager.setDefend(PriorityManager.getDefend() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Defense());
                }
                break;
            case HARVESTING:
                PriorityManager.setHarvest(PriorityManager.getHarvest() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Harvesting());
                }
                break;
            case FORGING:
                PriorityManager.setForge(PriorityManager.getForge() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Forging());
                }
                break;
            case HEALING:
                PriorityManager.setHeal(PriorityManager.getHeal() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToBottom(new Healing());
                }
                break;
            case SCOUTING:
                PriorityManager.setScout(PriorityManager.getScout() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Scouting());
                }
                break;
            case PLANTING:
                PriorityManager.setPlant(PriorityManager.getPlant() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Planting());
                }
                break;
            case SMITHING:
                PriorityManager.setSmith(PriorityManager.getSmith() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Smithing());
                }
                break;
            case SMELTING:
                PriorityManager.setSmelt(PriorityManager.getSmelt() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Smelting());
                }
                break;
            case RAIDING:
                PriorityManager.setRaid(PriorityManager.getRaid() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                /*for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Raiding());
                }*/
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
                for (int i = 0; i < amt; i++) {
                    actionManager.addToTurnEnd(new Trading());
                }
                break;
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

    @Override
    protected void postMultiline() {
        printPrompt(PromptMessage.PRIORITY_MENU, true, true);
    }
}
