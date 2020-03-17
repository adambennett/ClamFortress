package main.utilities.consoleIO;

import main.enums.*;
import main.utilities.builders.*;
import main.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;

public class LoginMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.NEW_GAME);
        consoleCommands.put("2", MenuCommands.LOAD_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case NEW_GAME:
                setBuilder(new GameBuilder());
                DifficultyMenu diff = new DifficultyMenu();
                diff.printPrompt(PromptMessage.DIFF_MENU, true);
                break;
            case LOAD_GAME:
                Database.loadDatabase();
                Logger.getGlobal().info("No saved games found!");
                processCommand(MenuCommands.NEW_GAME, new ArrayList<>());
                break;
        }
    }

}
