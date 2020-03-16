package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.game.*;

import java.util.*;

public class PriorityMenu extends AbstractConsole {

    public PriorityMenu() { super(); }

    @Override
    protected void initializeCommands() {
        manager = Game.priorityManager;
        manager.setPointsRemaining(manager.getPointsRemaining() + Game.getVillage().getSurvivors().size());
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
        currentGame.fillActionManagerWithSimpleActions();
        // complicated actions logic
        currentGame.runActions();
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        Integer amt = 0;
        if (args.size() > 0) {
        try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) { }}
        if (amt > manager.getPointsRemaining()) {
            amt = manager.getPointsRemaining();
        }
        switch(cmd) {
            case CONTINUE:
                runActions();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case DYNAMIC_FOOD_A:
                manager.setFood1(manager.getFood1() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case DYNAMIC_FOOD_B:
                manager.setFood2(manager.getFood2() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case DYNAMIC_FOOD_C:
                manager.setFood3(manager.getFood3() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case PRAY:
                manager.setPray(manager.getPray() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case FORAGE:
                manager.setForage(manager.getForage() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case WOODCUTTING:
                manager.setWoodcut(manager.getWoodcut() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case STONE_PICK:
                manager.setStone(manager.getStone() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case MINING:
                manager.setMine(manager.getMine() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case DEFENDING:
                manager.setDefend(manager.getDefend() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case HARVESTING:
                manager.setHarvest(manager.getHarvest() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case FORGING:
                manager.setForge(manager.getForge() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case HEALING:
                manager.setHeal(manager.getHeal() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case SCOUTING:
                manager.setScout(manager.getScout() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case PLANTING:
                manager.setPlant(manager.getPlant() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case SMITHING:
                manager.setSmith(manager.getSmith() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case SMELTING:
                manager.setSmelt(manager.getSmelt() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case RAIDING:
                manager.setRaid(manager.getRaid() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case ENGINEERING:
                manager.setEngineer(manager.getEngineer() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case BUILDING:
                manager.setBuild(manager.getBuild() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
            case TRADING:
                manager.setTrade(manager.getTrade() + amt);
                manager.setPointsRemaining(manager.getPointsRemaining() - amt);
                break;
        }
    }

    @Override
    protected void postMultiline() {
        printPrompt(PromptMessage.PRIORITY_MENU, true, true);
    }
}
