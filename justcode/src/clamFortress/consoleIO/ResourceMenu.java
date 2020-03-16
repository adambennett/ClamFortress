package clamFortress.consoleIO;

import clamFortress.enums.*;

import java.util.*;

public class ResourceMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
        }
    }
}
