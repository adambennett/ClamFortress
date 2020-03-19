package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;

public class DifficultyMenu extends AbstractConsole {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.EASY);
        consoleCommands.put("2", MenuCommands.STANDARD);
        consoleCommands.put("3", MenuCommands.HARD);
        consoleCommands.put("4", MenuCommands.BRUTAL);
        consoleCommands.put("5", MenuCommands.NIGHTMARE);
        consoleCommands.put("6", MenuCommands.IMPOSSIBLE);
        consoleCommands.put("7", MenuCommands.CUSTOM);
        consoleCommands.put("8", MenuCommands.RANDOM);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case EASY:
                builder.setDifficulty(Difficulty.EASY);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case STANDARD:
                builder.setDifficulty(Difficulty.DEFAULT);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case HARD:
                builder.setDifficulty(Difficulty.HARD);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case BRUTAL:
                builder.setDifficulty(Difficulty.BRUTAL);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case NIGHTMARE:
                builder.setDifficulty(Difficulty.NIGHTMARE);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case IMPOSSIBLE:
                builder.setDifficulty(Difficulty.IMPOSSIBLE);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case CUSTOM:
                builder.setDifficulty(Difficulty.CUSTOM);
                CustomDifficultyMenu cdm = new CustomDifficultyMenu();
                cdm.printPromptCustomOptions();
                break;
            case RANDOM:
                builder.setDifficulty(Difficulty.RANDOM);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case NEW_GAME:
                beginGame();
                break;
            case CONTINUE:
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
        }
    }
}
