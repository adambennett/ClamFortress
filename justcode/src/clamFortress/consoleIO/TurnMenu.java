package clamFortress.consoleIO;

import clamFortress.actions.*;
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
        consoleCommands.put("0", MenuCommands.CONTINUE);
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
                advanceTurn();
            case SCORE_REALLY_BIG_HACKS:
                Database.score(1000);
                printPrompt(PromptMessage.TURN_MENU, true);
            case CONTINUE:
                new PriorityMenu().printPrompt(PromptMessage.PRIORITY_MENU, true);
        }
    }

    public void advanceTurn() {
        Integer dateInc = currentGame.advanceTurn();
        Logger.getGlobal().info("\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days");
        printPrompt(PromptMessage.TURN_MENU, true);
    }

    private void heal() {
        currentGame.actionManager.addToBottom(new Healing(currentGame.getVillage().getSurvivors()));

        /*
        Survivor targetHealer = new Survivor();
        int sumTotalHeal = targetHealer.getHealamt();
        for (Survivor  s : currentGame.getVillage().getSurvivors()) {
            if (s.hp < s.maxHp) {
                currentGame.actionManager.addToBottom(new Healing(s, targetHealer));
                sumTotalHeal -= 10;
            }
            if (sumTotalHeal < 0) { break; }
        }
        */
    }
}
