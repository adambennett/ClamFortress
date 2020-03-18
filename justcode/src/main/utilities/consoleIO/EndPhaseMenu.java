package main.utilities.consoleIO;

import main.enums.*;
import main.models.*;
import main.models.items.*;
import main.models.managers.*;
import main.utilities.persistence.*;

import java.util.*;

public class EndPhaseMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("1", MenuCommands.RESOURCES);
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("quit", MenuCommands.END_GAME);
        consoleCommands.put("save", MenuCommands.SAVE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                OutputManager.reset();
                for (GameObject obj : Game.getModifierObjects()) {
                    obj.standbyPhase();
                }
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case RESOURCES:
                OutputManager.print();
                printPrompt(PromptMessage.END_PHASE, true);
                break;
            case SKIP_TURN:
                OutputManager.reset();
                Game.advanceTurn();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case SAVE:
                Database.saveDatabase();
                printPrompt(PromptMessage.END_PHASE, true);
                break;
            case EXIT:
                Database.saveDatabase();
                System.exit(0);
            case END_GAME:
                GameManager.reset();
                new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
                break;
        }
    }
}
