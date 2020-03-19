package main.utilities.consoleIO;

import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.utilities.persistence.*;

import java.util.*;

public class TurnMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("quit", MenuCommands.END_GAME);
        consoleCommands.put("save", MenuCommands.SAVE);
        consoleCommands.put("end", MenuCommands.SKIP_TURN);
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("cheat", MenuCommands.SCORE_REALLY_BIG_HACKS);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("2", MenuCommands.RESOURCES);
        consoleCommands.put("3", MenuCommands.GAME_BOARD);
        consoleCommands.put("4", MenuCommands.INVENTORY);
        consoleCommands.put("5", MenuCommands.BUILDING);
        consoleCommands.put("6", MenuCommands.VILLAGERS);

    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
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
