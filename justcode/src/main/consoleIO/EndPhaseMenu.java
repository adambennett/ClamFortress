package main.consoleIO;

import main.enums.*;
import main.game.logic.*;

import java.util.*;
import java.util.logging.*;

public class EndPhaseMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("1", MenuCommands.RESOURCES);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                OutputManager.reset();
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case RESOURCES:
                OutputManager.print();
                printPrompt(PromptMessage.END_PHASE, true);
                break;
        }
    }
}
