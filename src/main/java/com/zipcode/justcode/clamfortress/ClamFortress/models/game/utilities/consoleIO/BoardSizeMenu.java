package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;

import java.util.*;

public class BoardSizeMenu extends AbstractConsole {


    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.GAME_BOARD);
        consoleCommands.put("2", MenuCommands.POPULATION);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        int amt = 0; if (args.size() > 0) { try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) {}}
        switch (cmd) {
            case GAME_BOARD:
                builder.setxMax(amt);
                printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case POPULATION:
                builder.setyMax(amt);
                printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case CONTINUE:
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case NEW_GAME:
                beginGame();
                break;
        }
    }
}
