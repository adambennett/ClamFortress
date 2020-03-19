package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;
import java.util.logging.*;

public class BoardSizeMenu extends AbstractConsole {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.GAME_BOARD);
        consoleCommands.put("2", MenuCommands.POPULATION);
        consoleCommands.put("0", MenuCommands.CONTINUE);
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
                new PopulationSetupMenu().printPrompt(PromptMessage.POP_SETUP, true);
                break;
        }
    }
}
