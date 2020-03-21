package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;
import java.util.logging.*;

public class PopulationSetupMenu extends AbstractConsole {


    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.POPCAP);
        consoleCommands.put("2", MenuCommands.POPULATION);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        int amt = 0; if (args.size() > 0) { try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) {}}
        switch (cmd) {
            case POPCAP:
                builder.setStartingPopCap(amt);
                printPrompt(PromptMessage.POP_SETUP, true);
                break;
            case POPULATION:
                builder.setStartingPop(amt);
                printPrompt(PromptMessage.POP_SETUP, true);
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
