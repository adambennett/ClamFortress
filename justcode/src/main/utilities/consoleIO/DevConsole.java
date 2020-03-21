package main.utilities.consoleIO;

import main.enums.*;
import main.interfaces.*;
import main.models.*;
import main.utilities.*;

import java.util.*;

public class DevConsole extends AbstractConsole implements DynamicConsole {

    private final AbstractConsole returnTo;

    public DevConsole(AbstractConsole lastConsole) {
        super();
        this.returnTo = lastConsole;
    }

    // Unused for this menu
    protected void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            this.returnTo.printPrompt(getMessageFromConsole(this.returnTo), true);
        }
    }

    public Integer findAndProcessCommandCustomOptions(ArrayList<String> args) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (String arg : args) {
            try { ints.add(Integer.parseInt(arg)); }
            catch (NumberFormatException ignored) {}
        }
        int sum  = 0;
        for (Integer i : ints) {
            sum += i;
        }
        return sum;
    }

    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {
        if (!cmd.equals("~")) {
            if (Archive.getInstance().isItem(cmd) && Archive.getInstance().get(cmd) != null) {
                Integer amt = findAndProcessCommandCustomOptions(args);
                if (amt < 1) { amt = 1; }
                GameObject obj = Archive.getInstance().get(cmd);
                GameUtils.devConsoleObtainObject(obj, amt);
                ConsoleServices.println("GameObject OBTAINED from Archive: " + cmd + " (x" + amt + ")");
            } else {
                ConsoleServices.println("GameObject NOT FOUND in Archive: " + cmd);
            }
        }
        printPrompt(PromptMessage.DEV_CONSOLE, true);
    }
}
