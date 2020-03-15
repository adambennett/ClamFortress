package clamFortress.consoleIO;

import clamFortress.enums.*;

import java.util.*;

public class TurnMenu extends AbstractConsole  {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("exit", MenuCommands.EXIT);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.EXIT) {
            return;
        }
    }
}
