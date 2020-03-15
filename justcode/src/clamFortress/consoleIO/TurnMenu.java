package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.game.logic.*;
import clamFortress.utilities.persistence.*;

import java.util.*;
import java.util.logging.*;

public class TurnMenu extends AbstractConsole  {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("exit", MenuCommands.EXIT);
        consoleCommands.put("skip", MenuCommands.SKIP_TURN);
        consoleCommands.put("end", MenuCommands.END_GAME);
        consoleCommands.put("cheat", MenuCommands.SCORE_REALLY_BIG_HACKS);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case EXIT:
                Database.saveDatabase();
                return;
            case END_GAME:
                GameManager.reset();
                new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
                return;
            case SKIP_TURN:
                Integer dateInc = currentGame.advanceTurn();
                Logger.getGlobal().info("\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days");
                printPrompt(PromptMessage.TURN_MENU, true);
            case SCORE_REALLY_BIG_HACKS:
                Database.score(1000);
                printPrompt(PromptMessage.TURN_MENU, true);
        }
    }


}
