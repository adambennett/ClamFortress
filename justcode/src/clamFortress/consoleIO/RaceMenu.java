package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.utilities.persistence.*;

import java.util.*;

public class RaceMenu extends AbstractConsole {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.HUMAN);
        if (Database.getOrcsUnlocked()) {
            consoleCommands.put("2", MenuCommands.ORC);
        }
        if (Database.getElvesUnlocked()) {
            consoleCommands.put("3", MenuCommands.ELF);
        }
        if (Database.getDwarvesUnlocked()) {
            consoleCommands.put("4", MenuCommands.DWARF);
        }
        if (Database.getClamanUnlocked()) {
            consoleCommands.put("5", MenuCommands.CLAMAN);
        }
        if (Database.getAliensUnlocked()) {
            consoleCommands.put("6", MenuCommands.ALIEN);
        }
        consoleCommands.put("7", MenuCommands.RANDOM_RACE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case HUMAN:
                builder.setRace(Race.HUMAN);
                break;
            case ORC:
                builder.setRace(Race.ORC);
                break;
            case DWARF:
                builder.setRace(Race.DWARF);
                break;
            case ALIEN:
                builder.setRace(Race.ALIEN);
                break;
            case CLAMAN:
                builder.setRace(Race.CLAMAN);
                break;
            case ELF:
                builder.setRace(Race.ELF);
                break;
            case RANDOM_RACE:
                builder.setRace(Race.getRandomRace());
                break;
        }

        BiomeMenu biomeMenu = new BiomeMenu();
        biomeMenu.printPrompt(PromptMessage.BIOME_MENU, true);
    }
}
