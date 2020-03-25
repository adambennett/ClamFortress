package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;

import java.util.*;

public class StartingEraMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {

        consoleCommands.put("1", MenuCommands.STONE);
        consoleCommands.put("2", MenuCommands.BRONZE);
        consoleCommands.put("3", MenuCommands.IRON);
        consoleCommands.put("4", MenuCommands.EXPLORE);
        consoleCommands.put("5", MenuCommands.INDUSTRIAL);
        consoleCommands.put("6", MenuCommands.INFORMATION);
        consoleCommands.put("7", MenuCommands.FUTURE);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);

    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case NEW_GAME:
                beginGame();
                break;
            case STONE:
                builder.setStartingEra(new StoneAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case BRONZE:
                builder.setStartingEra(new BronzeAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case IRON:
                builder.setStartingEra(new IronAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case EXPLORE:
                builder.setStartingEra(new ExplorationAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case INDUSTRIAL:
                builder.setStartingEra(new IndustrialAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case INFORMATION:
                builder.setStartingEra(new InformationAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case FUTURE:
                builder.setStartingEra(new FutureAge());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
        }
    }
}
