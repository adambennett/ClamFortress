package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

import java.util.*;

public class LoadGameMenu extends AbstractConsole implements DynamicConsole {

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

    public void findAndProcessCommandCustomOptions(ArrayList<String> args) {
        if (args.size() > 0) {
            ArrayList<Long> ints = new ArrayList<>();
            for (String arg : args) {
                try { ints.add(Long.parseLong(arg)); }
                catch (NumberFormatException ignored) {}
            }
            for (Long lo : ints) {
                if (Database.isGame(lo)) {
                    Database.setCurrentGame(lo);
                   // Database.getCurrentGame().gameManager.gameIsLoaded = true;
                    advanceToFirstTurn();
                    return;
                }
            }
        }
        printPrompt(PromptMessage.LOAD_GAME, true);
    }

    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {
        args.add(0, cmd);
        findAndProcessCommandCustomOptions(args);
    }
}
