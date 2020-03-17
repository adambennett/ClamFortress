package main.consoleIO;

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
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case EASY:
                builder.setDifficulty(Difficulty.EASY);
                break;
            case STANDARD:
                builder.setDifficulty(Difficulty.DEFAULT);
                break;
            case HARD:
                builder.setDifficulty(Difficulty.HARD);
                break;
            case BRUTAL:
                builder.setDifficulty(Difficulty.BRUTAL);
                break;
            case NIGHTMARE:
                builder.setDifficulty(Difficulty.NIGHTMARE);
                break;
            case IMPOSSIBLE:
                builder.setDifficulty(Difficulty.IMPOSSIBLE);
                break;
            case CUSTOM:
                builder.setDifficulty(Difficulty.CUSTOM);
                CustomDifficultyMenu cdm = new CustomDifficultyMenu();
                cdm.printPromptCustomOptions();
                break;
            case RANDOM:
                builder.setDifficulty(Difficulty.RANDOM);
                break;
        }

        if (!cmd.equals(MenuCommands.CUSTOM)) {
            RaceMenu raceMenu = new RaceMenu();
            raceMenu.printPrompt(PromptMessage.RACE_MENU, true);
        }
    }
}
