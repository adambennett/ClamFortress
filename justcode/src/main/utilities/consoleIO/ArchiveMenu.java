package main.utilities.consoleIO;

import main.enums.*;

import java.util.*;

public class ArchiveMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
        }
    }
}
