package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

import java.util.*;

public class CustomDifficultyMenu extends AbstractConsole implements DynamicConsole {

    // Unused for this menu
    public void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
        }
    }

    public void findAndProcessCommandCustomOptions(ArrayList<String> args) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (String arg : args) {
            try { ints.add(Integer.parseInt(arg)); }
            catch (NumberFormatException ignored) {}
        }
        builder.setCustomMods(ints);
        new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
    }

    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {
        args.add(0, cmd);
        findAndProcessCommandCustomOptions(args);
    }
}
