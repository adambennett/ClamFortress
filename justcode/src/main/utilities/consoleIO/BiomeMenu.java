package main.utilities.consoleIO;

import main.enums.*;
import main.models.nodes.*;
import main.models.nodes.biomes.*;

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
                builder.setStartBiome(new DesertBiome());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case GRASS:
                builder.setStartBiome(new Grasslands());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case JUNGLE:
                builder.setStartBiome(new Forest());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case MOUNTAIN:
                builder.setStartBiome(new Mountainous());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case SEA:
                builder.setStartBiome(new Ocean());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case TUNDRA:
                builder.setStartBiome(new Icelands());
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
        }
    }
}
