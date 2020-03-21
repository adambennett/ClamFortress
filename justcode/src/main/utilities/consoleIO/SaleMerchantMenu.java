package main.utilities.consoleIO;

import main.enums.*;
import main.interfaces.*;

import java.util.*;

public class SaleMerchantMenu extends AbstractConsole implements DynamicConsole {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {

    }

    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {

    }
}
