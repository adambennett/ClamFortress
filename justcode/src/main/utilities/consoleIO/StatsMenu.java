package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;

public class StatsMenu extends AbstractConsole {


    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.STATS);
        consoleCommands.put("2", MenuCommands.LEADERBOARD);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        int amt = 0; if (args.size() > 0) { try { amt = Integer.parseInt(args.get(0)); } catch (NumberFormatException ignored) {}}
        switch (cmd) {
            case STATS:
                new MidConsoleMenu().printPrompt(PromptMessage.STAT_VIEW, true);
                break;
            case LEADERBOARD:
                new MidConsoleMenu().printPrompt(PromptMessage.LEADERBOARD, true);
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
