package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;

public class MainMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.NEW_GAME);
        consoleCommands.put("2", MenuCommands.LOAD_GAME);
        consoleCommands.put("3", MenuCommands.STATS);
        consoleCommands.put("4", MenuCommands.ARCHIVE);
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
                if (Database.getGames().size() < 1) {
                    Logger.getGlobal().info("No saved games found!");
                    setBuilder(new GameBuilder());
                    new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                } else {
                    // TODO: change this to actual loading menu
                    Logger.getGlobal().info("No saved games found!");
                    setBuilder(new GameBuilder());
                    new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                }
                break;
            case STATS:
                new StatsMenu().printPrompt(PromptMessage.STATS_MENU, true);
                break;
            case ARCHIVE:
                new MidConsoleMenu().printPrompt(PromptMessage.ARCHIVE, true);
                break;
            case LOGOUT:
                new LoginMenu().printPrompt(PromptMessage.LOGIN, true);
                break;
        }
    }

}
