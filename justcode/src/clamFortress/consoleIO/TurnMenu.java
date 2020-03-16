package clamFortress.consoleIO;

import clamFortress.actions.*;
import clamFortress.enums.*;
import clamFortress.game.*;
import clamFortress.game.logic.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;

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
            case EXIT:
                Database.saveDatabase();
                return;
            case END_GAME:
                GameManager.reset();
                new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
                return;
            case SKIP_TURN:
                Game.fillActionManagerWithSimpleActions();
                advanceTurn();
            case RESOURCES:
                new ResourceMenu().printPrompt(PromptMessage.RESOURCE_VIEW, true);
            case SCORE_REALLY_BIG_HACKS:
                int amt = 1000;
                if (args.size() > 0) {
                    amt = 10000;
                }
                Database.score(amt);
                printPrompt(PromptMessage.TURN_MENU, true);
            case CONTINUE:
                PriorityMenu priorityMenu = new PriorityMenu();
                priorityMenu.printPrompt(PromptMessage.PRIORITY_MENU, true, true);
        }
    }

    public void advanceTurn() {
        Integer dateInc = Game.advanceTurn();
        Logger.getGlobal().info("\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days");
        printPrompt(PromptMessage.TURN_MENU, true);
    }
}
