package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class EndPhaseMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("1", MenuCommands.RESOURCES);
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("quit", MenuCommands.END_GAME);
        consoleCommands.put("save", MenuCommands.SAVE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                OutputManager.reset();
                for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                    obj.standbyPhase();
                }
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case RESOURCES:
                OutputManager.print();
                printPrompt(PromptMessage.END_PHASE, true);
                break;
            case SKIP_TURN:
                OutputManager.reset();
                Database.getCurrentGame().advanceTurn();
                new EndPhaseMenu().printPrompt(PromptMessage.END_PHASE, true);
                break;
            case SAVE:
                Database.saveDatabase();
                printPrompt(PromptMessage.END_PHASE, true);
                break;
            case EXIT:
                Database.saveDatabase();
                System.exit(0);
            case END_GAME:
                new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
                break;
        }
    }
}
