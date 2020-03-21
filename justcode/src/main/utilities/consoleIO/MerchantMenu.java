package main.utilities.consoleIO;

import javafx.scene.shape.*;
import main.enums.*;
import main.interfaces.*;
import main.models.*;
import main.models.people.merchants.*;
import main.utilities.*;
import main.utilities.stringUtils.*;

import java.util.*;

public class MerchantMenu extends AbstractConsole implements DynamicConsole {

    // Unused for this menu
    public void initializeCommands() {        
        consoleCommands.put("0", MenuCommands.CONTINUE);
        consoleCommands.put("5", MenuCommands.SELL);
    }
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case CONTINUE:
                new TurnMenu().printPrompt(PromptMessage.TURN_MENU, true);
                break;
            case SELL:
                printPrompt(PromptMessage.MERCHANT, true);
                break;
        }
    }

    public void findAndProcessCommandCustomOptions(ArrayList<String> args) {
        if (args.size() > 0) {
            if (Game.getVillage().getVistingMerchants().size() > 0) {
                Merchant m = Game.getVillage().getVistingMerchants().get(0);
                String key = StringHelpers.capFirstLetter(args.get(0).toLowerCase());
                boolean bought = false;
                if (m.getWares().containsKey(key)) {
                  bought = true;
                } else {
                    String fullCmd = "";
                    for (String s : args) {
                        fullCmd += StringHelpers.capFirstLetter(s.toLowerCase()) + " ";
                    }
                    fullCmd = fullCmd.trim();
                    if (m.getWares().containsKey(fullCmd)) {
                        bought = true;
                        key = fullCmd;
                    }
                }
                if (bought) {
                    if (Game.getVillage().getCoins() >= m.getWares().get(key)) {
                        GameObject obj = Archive.getInstance().getGameObj(key);
                        GameUtils.obtainGameObject(obj, 1);
                        Game.getVillage().subCoins(m.getWares().get(key));
                        m.purchase(key);
                        printPrompt(PromptMessage.MERCHANT, true);
                    } else {
                        printPrompt(PromptMessage.MERCHANT, false);
                        printPrompt("Not enough Coins!", true);
                    }
                }
                else {
                    printPrompt(PromptMessage.MERCHANT, true);
                }
            } else {
                printPrompt(PromptMessage.MERCHANT, true);
            }
        }
    }

    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {
        args.add(0, cmd);
        findAndProcessCommandCustomOptions(args);
    }
}
