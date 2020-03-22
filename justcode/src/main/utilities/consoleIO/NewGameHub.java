package main.utilities.consoleIO;

import main.enums.*;
import main.utilities.*;

import java.util.*;
import java.util.logging.*;

public class NewGameHub extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.DIFFICULTY);
        consoleCommands.put("2", MenuCommands.BIOME);
        consoleCommands.put("3", MenuCommands.RACE);
        consoleCommands.put("4", MenuCommands.POPULATION);
        consoleCommands.put("5", MenuCommands.GAME_BOARD);
        consoleCommands.put("6", MenuCommands.DIFFICULTY_MODS);
        consoleCommands.put("7", MenuCommands.STARTING_ERA);
        consoleCommands.put("8", MenuCommands.VIEW_SETTINGS);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("quit", MenuCommands.NEW_GAME);
        consoleCommands.put("reset", MenuCommands.RESET);

    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case NEW_GAME:
                new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case CONTINUE:
                beginGame();
                break;
            case EXIT:
                System.exit(0);
            case POPULATION:
                new PopulationSetupMenu().printPrompt(PromptMessage.POP_SETUP, true);
                break;
            case GAME_BOARD:
                new BoardSizeMenu().printPrompt(PromptMessage.BOARD_SIZE, true);
                break;
            case DIFFICULTY:
                new DifficultyMenu().printPrompt(PromptMessage.DIFF_MENU, true);
                break;
            case BIOME:
                new BiomeMenu().printPrompt(PromptMessage.BIOME_MENU, true);
                break;
            case RACE:
                new RaceMenu().printPrompt(PromptMessage.RACE_MENU, true);
                break;
            case DIFFICULTY_MODS:
                //new CustomDifficultyMenu().printPromptCustomOptions();
                new CustomDifficultyMenu().printPrompt(PromptMessage.CUSTOM_DIFF_MENU, true);
                break;
            case VIEW_SETTINGS:
                ConsoleServices.println(builder.toString());
                printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case RESET:
                builder.reset();
                ConsoleServices.println("Game settings have been reset to default!");
                printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case STARTING_ERA:
                new StartingEraMenu().printPrompt(PromptMessage.START_ERA, true);
                break;
        }
    }


}
