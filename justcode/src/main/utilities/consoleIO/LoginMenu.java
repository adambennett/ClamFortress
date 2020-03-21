package main.utilities.consoleIO;

import main.enums.*;
import main.models.*;
import main.utilities.builders.*;

import java.util.*;

public class LoginMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.LOGIN);
        consoleCommands.put("2", MenuCommands.REGISTER);
        consoleCommands.put("3", MenuCommands.CONTINUE);
        consoleCommands.put("0", MenuCommands.EXIT);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case LOGIN:
                new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case REGISTER:
                new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
                break;
            case EXIT:
                System.exit(0);
            case CONTINUE:
                builder = new GameBuilder();
                builder.setStartingPop(2000);
                builder.setStartingPopCap(2500);
                builder.setxMax(50);
                builder.setyMax(50);
                builder.buildGame();
                beginGame();
                break;
        }
    }
}
