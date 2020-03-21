package main.utilities.consoleIO;

import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.utilities.*;
import main.utilities.persistence.*;

import java.util.*;

public class TurnMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("quit", MenuCommands.END_GAME);
        consoleCommands.put("save", MenuCommands.SAVE);
        consoleCommands.put("end", MenuCommands.SKIP_TURN);
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("cheat", MenuCommands.SCORE_REALLY_BIG_HACKS);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("2", MenuCommands.STATS);
        consoleCommands.put("3", MenuCommands.GAME_BOARD);
        consoleCommands.put("4", MenuCommands.RESOURCES);
        if (Game.getVillage().getInventory().getItems().size() > 0) {
            consoleCommands.put("5", MenuCommands.INVENTORY);
        } else {
            consoleCommands.put("5", MenuCommands.OPTION_UNAVAILABLE);
        }
        if (Game.getVillage().getBuildings().size() > 0) {
            consoleCommands.put("6", MenuCommands.BUILDING);
        } else {
            consoleCommands.put("6", MenuCommands.OPTION_UNAVAILABLE);
        }
        if (Game.getVillage().getPopulation() > 0) {
            consoleCommands.put("7", MenuCommands.VILLAGERS);
        } else {
            consoleCommands.put("7", MenuCommands.OPTION_UNAVAILABLE);
        }
        if (Game.getVillage().getVistingMerchants().size() > 0) {
            consoleCommands.put("8", MenuCommands.MERCHANT);
        } else {
            consoleCommands.put("8", MenuCommands.OPTION_UNAVAILABLE);
        }
        if (Game.canRaid()) {
            consoleCommands.put("9", MenuCommands.RAIDING);
        } else {
            consoleCommands.put("9", MenuCommands.OPTION_UNAVAILABLE);
        }
        int trainingCost = GameManager.getInstance().getTrainingCost();
        if (Game.getVillage().getCoins() >= trainingCost) {
            consoleCommands.put("10", MenuCommands.TRAINING);
        } else {
            consoleCommands.put("10", MenuCommands.OPTION_UNAVAILABLE);
        }
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case TRAINING:
                printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case MERCHANT:
                new MerchantMenu().printPrompt(PromptMessage.MERCHANT, true);
                break;
            case OPTION_UNAVAILABLE:
                printPrompt(PromptMessage.TURN_MENU, false);
                printPrompt("That option is not currently available. Please choose a different option.", true);
                break;
            case RAIDING:
                String output = GameUtils.getNewRaidCity();
                if (!output.equals("")) {
                    printPrompt(PromptMessage.TURN_MENU, false);
                    printPrompt(output, true);
                } else {
                    printPrompt(PromptMessage.TURN_MENU, true);
                }
                break;
            case BUILDING:
                new MidTurnMenu().printPrompt(PromptMessage.BUILDINGS, true);
                break;
            case GAME_BOARD:
                new MidTurnMenu().printPrompt(PromptMessage.GAME_BOARD, true);
                break;
            case SAVE:
                Database.saveDatabase();
                printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case EXIT:
                Database.saveDatabase();
                System.exit(0);
            case END_GAME:
                GameManager.reset();
                new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case SKIP_TURN:
                Game.advanceTurn();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case STATS:
                new MidTurnMenu().printPrompt(PromptMessage.STAT_VIEW, true);
                break;
            case RESOURCES:
                new MidTurnMenu().printPrompt(PromptMessage.RESOURCE_VIEW, true);
                break;
            case INVENTORY:
                new MidTurnMenu().printPrompt(PromptMessage.INVENTORY_VIEW, true);
                break;
            case VILLAGERS:
                new MidTurnMenu().printPrompt(PromptMessage.VILLAGERS, true);
                break;
            case SCORE_REALLY_BIG_HACKS:
                int amt = 1000;
                if (args.size() > 0) {
                    amt = 10000;
                }
                Database.score(amt);
                printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case CONTINUE:
                for (GameObject obj : Game.getModifierObjects()) {
                    obj.priorityPhase();
                }
                PriorityMenu priorityMenu = new PriorityMenu();
                priorityMenu.printPrompt(PromptMessage.PRIORITY_MENU, true, true);
                break;
        }
    }
}
