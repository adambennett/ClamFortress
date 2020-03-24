package main.utilities.consoleIO;

import main.enums.*;
import main.interfaces.*;
import main.models.*;
import main.utilities.stringUtils.*;

import java.util.*;

public class SaleMerchantMenu extends AbstractConsole implements DynamicConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("0", MenuCommands.CONTINUE);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        if (cmd == MenuCommands.CONTINUE) {
            new MerchantMenu().printPrompt(PromptMessage.MERCHANT, true);
        }
    }

    public void findAndProcessCommandCustomOptions(ArrayList<String> args) {
        if (args.size() > 0) {
            ArrayList<Integer> ints = new ArrayList<>();
            ArrayList<String> words = new ArrayList<>();
            for (String arg : args) {
                try { ints.add(Integer.parseInt(arg)); }
                catch (NumberFormatException ignored) {
                    words.add(arg);
                }
            }
            int amt  = 0;
            for (Integer i : ints) {
                amt += i;
            }
            if (amt < 1) { amt = 1; }
            Inventory inv = Game.getVillage().getInventory();
            String key = args.get(0).toLowerCase();
            boolean bought = false;
            if (inv.containsItem(key)) {
                bought = true;
            } else {
                String fullCmd = "";
                for (String s : words) {
                    fullCmd += s.toLowerCase() + " ";
                }
                fullCmd = fullCmd.trim();
                if (inv.containsItem(key)) {
                    bought = true;
                    key = fullCmd;
                }
            }
            if (bought) {
                String merchant = Game.getVillage().getVistingMerchants().get(0).getName();
                boolean sold = inv.remove(key, amt);
                if (sold) {
                    int amtPaid = inv.getItemValue(key);
                    Game.getVillage().incCoins(amtPaid);
                    StringHelpers.reloadStrings();
                    printPrompt(PromptMessage.SALE_MERCHANT, false);
                    printPrompt("Sold " + amt + "x " + key + " to " + merchant + " for " + amtPaid + " Coins", true);
                } else {
                    printPrompt(PromptMessage.SALE_MERCHANT, false);
                }
            }
        }
        else {
            printPrompt(PromptMessage.SALE_MERCHANT, true);
        }
    }


    @Override
    public void runDynamo(String cmd, ArrayList<String> args) {
        args.add(0, cmd);
        findAndProcessCommandCustomOptions(args);
    }
}
