package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;

public class LoginMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.LOGIN);
        consoleCommands.put("2", MenuCommands.REGISTER);
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
        }
    }
}
