package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.game.regions.*;

import java.util.*;
import java.util.logging.*;

public class EndPhaseMenu extends AbstractConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            new TurnMenu().advanceTurn();
        }
    }
}
