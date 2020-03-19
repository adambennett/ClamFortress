package main.utilities.consoleIO;

import main.enums.*;
import main.models.nodes.biomes.*;

import java.util.*;
import java.util.logging.*;

public class PopulationSetupMenu extends AbstractConsole {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.POPCAP);
        consoleCommands.put("2", MenuCommands.POPULATION);
        consoleCommands.put("0", MenuCommands.CONTINUE);
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
                if (builder.getStartingPopCap() < 5) {
                    builder.setStartingPopCap(5);
                }
                boolean setup = setupGame();
                if (setup) {
                    advanceToFirstTurn();
                } else {
                    Logger.getGlobal().warning("Game was not created properly, returning to Login Screen");
                    new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
                }
                break;
        }
    }

    public Boolean setupGame() {
        Boolean toRet = builder.buildGame();
        String gameInfo = "";
        gameInfo += "\n\nGame Information:\n  Difficulty: " + builder.getDifficulty().toString();
        gameInfo += "\n  Race: " + builder.getRace().toString();
        gameInfo += "\n  Starting Biome: " + builder.getStartBiome().toString();
        if (builder.getCustomMods().size() > 0) {
            gameInfo += "\n  All modifiers: ";
            Collections.sort(builder.getCustomMods());
            for (Integer i : builder.getCustomMods()) { gameInfo += i + ", "; }
            gameInfo = gameInfo.substring(0, gameInfo.length() - 2);
        }
        gameInfo += "\n";
        Logger.getGlobal().info(gameInfo);
        return toRet;
    }

    public void advanceToFirstTurn() {
        printPrompt(PromptMessage.BLURB, false);
        TurnMenu turnMenu = new TurnMenu();
        turnMenu.printPrompt(PromptMessage.TURN_MENU, true);
    }
}
