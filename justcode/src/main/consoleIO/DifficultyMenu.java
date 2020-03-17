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
                builder.setDifficulty(Modes.EASY);
                break;
            case STANDARD:
                builder.setDifficulty(Modes.DEFAULT);
                break;
            case HARD:
                builder.setDifficulty(Modes.HARD);
                break;
            case BRUTAL:
                builder.setDifficulty(Modes.BRUTAL);
                break;
            case NIGHTMARE:
                builder.setDifficulty(Modes.NIGHTMARE);
                break;
            case IMPOSSIBLE:
                builder.setDifficulty(Modes.IMPOSSIBLE);
                break;
            case CUSTOM:
                builder.setDifficulty(Modes.CUSTOM);
                CustomDifficultyMenu cdm = new CustomDifficultyMenu();
                cdm.printPromptCustomOptions();
                break;
            case RANDOM:
                builder.setDifficulty(Modes.RANDOM);
                break;
        }

        if (!cmd.equals(MenuCommands.CUSTOM)) {
            RaceMenu raceMenu = new RaceMenu();
            raceMenu.printPrompt(PromptMessage.RACE_MENU, true);
        }
    }
}
