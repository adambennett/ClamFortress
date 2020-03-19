package main.utilities.consoleIO;

import main.enums.*;
import main.utilities.*;

import java.util.*;

public class CustomDifficultyMenu extends AbstractConsole {

    // Unused for this menu
    protected void initializeCommands() {}
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {}

    public void printPromptCustomOptions() {
        String promptString = GameStrings.getStringFromPromptType(PromptMessage.CUSTOM_DIFF_MENU);
        ConsoleServices.println(promptString);
        getUserInputForCustomOptions();
    }

    protected void getUserInputForCustomOptions() {
        String input = ConsoleServices.getStringInput("");
        String[] splited = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        Collections.addAll(argus, splited);
        while (argus.size() < 1) { argus = generateUserInput(); }
        findAndProcessCommandCustomOptions(argus);
    }

    public void findAndProcessCommandCustomOptions(ArrayList<String> args) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (String arg : args) {
            try { ints.add(Integer.parseInt(arg)); }
            catch (NumberFormatException ignored) {}
        }
        builder.setCustomMods(ints);
        new NewGameHub().printPrompt(PromptMessage.NEW_GAME_HUB, true);
    }
}
