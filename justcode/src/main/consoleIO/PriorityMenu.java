package main.consoleIO;

import main.enums.*;
import main.game.*;
import main.game.logic.*;

import java.util.*;

public class PriorityMenu extends AbstractConsole {

    public PriorityMenu() { super(); }

    @Override
    protected void initializeCommands() {
        int newPoints = PriorityManager.getPointsRemaining() + Game.getVillage().getPopulation();
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

    private void runActions() {
        Game.fillActionManagerWithSimpleActions();
        // complicated actions logic
        Game.runActions();
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        Integer amt = 0;
        if (args.size() > 0) {
        try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) { }}
        if (amt > PriorityManager.getPointsRemaining()) {
            amt = PriorityManager.getPointsRemaining();
        }
        switch(cmd) {
            case CONTINUE:
                runActions();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case DYNAMIC_FOOD_A:
                PriorityManager.setFood1(PriorityManager.getFood1() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case DYNAMIC_FOOD_B:
                PriorityManager.setFood2(PriorityManager.getFood2() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case DYNAMIC_FOOD_C:
                PriorityManager.setFood3(PriorityManager.getFood3() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case PRAY:
                PriorityManager.setPray(PriorityManager.getPray() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case FORAGE:
                PriorityManager.setForage(PriorityManager.getForage() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case WOODCUTTING:
                PriorityManager.setWoodcut(PriorityManager.getWoodcut() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case STONE_PICK:
                PriorityManager.setStone(PriorityManager.getStone() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case MINING:
                PriorityManager.setMine(PriorityManager.getMine() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case DEFENDING:
                PriorityManager.setDefend(PriorityManager.getDefend() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case HARVESTING:
                PriorityManager.setHarvest(PriorityManager.getHarvest() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case FORGING:
                PriorityManager.setForge(PriorityManager.getForge() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case HEALING:
                PriorityManager.setHeal(PriorityManager.getHeal() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case SCOUTING:
                PriorityManager.setScout(PriorityManager.getScout() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case PLANTING:
                PriorityManager.setPlant(PriorityManager.getPlant() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case SMITHING:
                PriorityManager.setSmith(PriorityManager.getSmith() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case SMELTING:
                PriorityManager.setSmelt(PriorityManager.getSmelt() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
                break;
            case RAIDING:
                PriorityManager.setRaid(PriorityManager.getRaid() + amt);
                PriorityManager.setPointsRemaining(PriorityManager.getPointsRemaining() - amt);
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
                break;
        }
    }

    @Override
    protected void postMultiline() {
        printPrompt(PromptMessage.PRIORITY_MENU, true, true);
    }
}
