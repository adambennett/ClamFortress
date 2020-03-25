package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;

import java.util.*;

public class DevConsole extends AbstractConsole implements DynamicConsole {

    private final AbstractConsole returnTo;

    public DevConsole(AbstractConsole lastConsole) {
        super();
        this.returnTo = lastConsole;
    }

    // Unused for this menu
    public void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            if (this.returnTo instanceof PriorityMenu) {
                this.returnTo.printPrompt(getMessageFromConsole(this.returnTo), true, true);
            } else {
                this.returnTo.printPrompt(getMessageFromConsole(this.returnTo), true);
            }
        }
    }

    public Integer findAndProcessCommandCustomOptions(ArrayList<String> args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        for (String arg : args) {
            try { ints.add(Integer.parseInt(arg)); }
            catch (NumberFormatException ignored) {
                words.add(arg);
            }
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
            ArrayList<Integer> ints = new ArrayList<>();
            ArrayList<String> words = new ArrayList<>();
            for (String arg : args) {
                try { ints.add(Integer.parseInt(arg)); }
                catch (NumberFormatException ignored) {
                    words.add(arg);
                }
            }
            int amt  = 0;
            for (Integer i : ints) {
                amt += i;
            }
            if (amt < 1) { amt = 1; }
            String fullName = "";
            fullName += cmd + " ";
            for (String s : words) {
                fullName += s + " ";
            }
            fullName = fullName.trim();
            if (cmd.toLowerCase().equals("all")) {
                if (amt > 99) { amt = 99; }
                ArrayList<GameObject> toAdd = new ArrayList<>();
                for (GameObject obj : Archive.getInstance().getArchive()) {
                    if (!(obj instanceof Era)) {
                        toAdd.add(obj);
                    }
                }
                for (GameObject obj : toAdd){
                    GameUtils.devConsoleObtainObject(obj, amt, this.returnTo, false);
                }
                printPrompt(PromptMessage.DEV_CONSOLE, false);
                printPrompt("DevConsole :: OBTAINING ALL GameObjects", true);
            } else {
                if (Archive.getInstance().isItem(fullName) && Archive.getInstance().get(fullName) != null) {
                    GameObject obj = Archive.getInstance().get(fullName);
                    GameUtils.devConsoleObtainObject(obj, amt, this.returnTo, true);
                    printPrompt(PromptMessage.DEV_CONSOLE, false);
                    printPrompt("GameObject OBTAINED from Archive: " + fullName + " (x" + amt + ")", true);

                } else if (Archive.getInstance().isItem(cmd) && Archive.getInstance().get(cmd) != null) {
                    GameObject obj = Archive.getInstance().get(cmd);
                    GameUtils.devConsoleObtainObject(obj, amt, this.returnTo, true);
                    printPrompt(PromptMessage.DEV_CONSOLE, false);
                    printPrompt("GameObject OBTAINED from Archive: " + cmd + " (x" + amt + ")", true);
                } else {
                    printPrompt(PromptMessage.DEV_CONSOLE, false);
                    printPrompt("GameObject NOT FOUND in Archive: " + fullName, true);
                }
            }
        }
    }

}
