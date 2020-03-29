package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

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
                Database.getCurrentGame().getVillage().setAgility(Database.getCurrentGame().getVillage().getAgility() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case STRENGTH:
                Database.getCurrentGame().getVillage().setStrength(Database.getCurrentGame().getVillage().getStrength() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case DEXTERITY:
                Database.getCurrentGame().getVillage().setDexterity(Database.getCurrentGame().getVillage().getDexterity() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case INTELLIGENCE:
                Database.getCurrentGame().getVillage().setIntelligence(Database.getCurrentGame().getVillage().getIntelligence() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case ENGINEERING:
                Database.getCurrentGame().getVillage().setEngineering(Database.getCurrentGame().getVillage().getEngineering() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case MAXHP:
                Database.getCurrentGame().getVillage().setMaxHP(Database.getCurrentGame().getVillage().getMaxHP() + ThreadLocalRandom.current().nextInt(1, 100));
                Database.getCurrentGame().getVillage().subCoins(Database.getCurrentGame().gameManager.getTrainingCost());
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
        }
    }
}
