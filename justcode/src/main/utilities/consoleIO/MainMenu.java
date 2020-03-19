package main.utilities.consoleIO;

import main.enums.*;
import main.utilities.builders.*;
import main.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;

public class MainMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.NEW_GAME);
        consoleCommands.put("2", MenuCommands.LOAD_GAME);
        consoleCommands.put("3", MenuCommands.STATS);
        consoleCommands.put("4", MenuCommands.ARCHIVE);
        consoleCommands.put("5", MenuCommands.OPTIONS);
        consoleCommands.put("0", MenuCommands.LOGOUT);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case NEW_GAME:
                setBuilder(new GameBuilder());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case LOAD_GAME:
                Database.loadDatabase();
                Logger.getGlobal().info("No saved games found!");
                setBuilder(new GameBuilder());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case STATS:
                // TODO
                printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case ARCHIVE:
                new ArchiveMenu().printPrompt(PromptMessage.ARCHIVE, true);
                break;
            case OPTIONS:
                // TODO
                printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case LOGOUT:
                new LoginMenu().printPrompt(PromptMessage.LOGIN, true);
                break;
        }
    }

}
