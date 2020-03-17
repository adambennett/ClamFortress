package main.consoleIO;

import main.enums.*;
import main.game.regions.*;

import java.util.*;
import java.util.logging.*;

public class BiomeMenu extends AbstractConsole {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.GRASS);
        consoleCommands.put("2", MenuCommands.DESERT);
        consoleCommands.put("3", MenuCommands.JUNGLE);
        consoleCommands.put("4", MenuCommands.MOUNTAIN);
        consoleCommands.put("5", MenuCommands.SEA);
        consoleCommands.put("6", MenuCommands.TUNDRA);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case DESERT:
                builder.setStartBiome(new Desert());
                break;
            case GRASS:
                builder.setStartBiome(new Grasslands());
                break;
            case JUNGLE:
                builder.setStartBiome(new Jungle());
                break;
            case MOUNTAIN:
                builder.setStartBiome(new Mountain());
                break;
            case SEA:
                builder.setStartBiome(new Sea());
                break;
            case TUNDRA:
                builder.setStartBiome(new Tundra());
                break;
        }
        setupGame();
    }

    private void setupGame() {
        setCurrentGame(builder.buildGame());
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
        printPrompt(PromptMessage.BLURB, false);
        TurnMenu turnMenu = new TurnMenu();
        turnMenu.printPrompt(PromptMessage.TURN_MENU, true);
    }
}
