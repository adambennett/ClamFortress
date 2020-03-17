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
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("end", MenuCommands.END_GAME);
        consoleCommands.put("save", MenuCommands.SAVE);
        consoleCommands.put("cheat", MenuCommands.SCORE_REALLY_BIG_HACKS);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("2", MenuCommands.RESOURCES);

    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case SAVE:
                Database.saveDatabase();
                printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case EXIT:
                Database.saveDatabase();
                break;
            case END_GAME:
                GameManager.reset();
                new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
                break;
            case SKIP_TURN:
                Game.advanceTurn();
                OutputManager.reset();
                printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case RESOURCES:
                new ResourceMenu().printPrompt(PromptMessage.RESOURCE_VIEW, true);
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
                PriorityMenu priorityMenu = new PriorityMenu();
                priorityMenu.printPrompt(PromptMessage.PRIORITY_MENU, true, true);
                break;
        }
    }
}
