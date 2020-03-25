package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class RaceMenu extends AbstractConsole {


    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.HUMAN);
        if (StatTracker.getOrcsUnlocked()) {
            consoleCommands.put("2", MenuCommands.ORC);
        }
        if (StatTracker.getElvesUnlocked()) {
            consoleCommands.put("3", MenuCommands.ELF);
        }
        if (StatTracker.getDwarvesUnlocked()) {
            consoleCommands.put("4", MenuCommands.DWARF);
        }
        if (StatTracker.getClamanUnlocked()) {
            consoleCommands.put("5", MenuCommands.CLAMAN);
        }
        if (StatTracker.getAliensUnlocked()) {
            consoleCommands.put("6", MenuCommands.ALIEN);
        }
        consoleCommands.put("7", MenuCommands.RANDOM_RACE);
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("9", MenuCommands.NEW_GAME);

    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case HUMAN:
                builder.setRace(Race.HUMAN);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case ORC:
                builder.setRace(Race.ORC);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case DWARF:
                builder.setRace(Race.DWARF);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case ALIEN:
                builder.setRace(Race.ALIEN);
                builder.setStartingEra(TechTree.getTail());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case CLAMAN:
                builder.setRace(Race.CLAMAN);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case ELF:
                builder.setRace(Race.ELF);
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case RANDOM_RACE:
                builder.setRace(Race.getRandomRace());
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case CONTINUE:
                new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
                break;
            case NEW_GAME:
                beginGame();
                break;

        }


    }
}
