package main.utilities.consoleIO;

import main.enums.*;
import main.models.*;
import main.models.managers.*;

import java.util.*;
import java.util.concurrent.*;

public class TrainingMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {        
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("1", MenuCommands.AGILITY);
        consoleCommands.put("2", MenuCommands.STRENGTH);
        consoleCommands.put("3", MenuCommands.DEXTERITY);
        consoleCommands.put("4", MenuCommands.INTELLIGENCE);
        consoleCommands.put("5", MenuCommands.ENGINEERING);
        consoleCommands.put("6", MenuCommands.MAXHP);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case AGILITY:
                Game.getVillage().setAgility(Game.getVillage().getAgility() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case STRENGTH:
                Game.getVillage().setStrength(Game.getVillage().getStrength() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case DEXTERITY:
                Game.getVillage().setDexterity(Game.getVillage().getDexterity() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case INTELLIGENCE:
                Game.getVillage().setIntelligence(Game.getVillage().getIntelligence() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case ENGINEERING:
                Game.getVillage().setEngineering(Game.getVillage().getEngineering() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case MAXHP:
                Game.getVillage().setMaxHP(Game.getVillage().getMaxHP() + ThreadLocalRandom.current().nextInt(1, 100));
                Game.getVillage().subCoins(GameManager.getInstance().getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
        }
    }
}
