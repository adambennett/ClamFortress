package clamFortress.consoleIO;

import clamFortress.enums.*;

import java.util.*;

public class RaceMenu extends AbstractConsole  {


    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.HUMAN);
        consoleCommands.put("2", MenuCommands.ORC);
        consoleCommands.put("3", MenuCommands.ELF);
        consoleCommands.put("4", MenuCommands.DWARF);
        consoleCommands.put("5", MenuCommands.CLAMAN);
        consoleCommands.put("6", MenuCommands.ALIEN);
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
        }

        BiomeMenu biomeMenu = new BiomeMenu();
        biomeMenu.printPrompt(PromptMessage.BIOME_MENU, true);
    }
}
