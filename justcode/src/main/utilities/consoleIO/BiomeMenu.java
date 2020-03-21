package main.utilities.consoleIO;

import main.enums.*;
import main.models.nodes.*;
import main.models.nodes.biomes.*;

import java.util.*;
import java.util.logging.*;

public class BiomeMenu extends AbstractConsole {


    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.GRASS);
        consoleCommands.put("2", MenuCommands.DESERT);
        consoleCommands.put("3", MenuCommands.JUNGLE);
        consoleCommands.put("4", MenuCommands.MOUNTAIN);
        consoleCommands.put("5", MenuCommands.SEA);
        consoleCommands.put("6", MenuCommands.TUNDRA);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case DESERT:
                builder.setStartBiome(new DesertBiome());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case GRASS:
                builder.setStartBiome(new Grasslands());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case JUNGLE:
                builder.setStartBiome(new Forest());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case MOUNTAIN:
                builder.setStartBiome(new Mountainous());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case SEA:
                builder.setStartBiome(new Ocean());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case TUNDRA:
                builder.setStartBiome(new Icelands());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
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
