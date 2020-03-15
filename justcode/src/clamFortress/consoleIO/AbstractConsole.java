package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.game.*;
import clamFortress.utilities.*;
import clamFortress.utilities.builders.*;

import java.util.*;

public abstract class AbstractConsole {

    protected static Game currentGame;
    protected static GameBuilder builder;
    protected Map<String, MenuCommands> consoleCommands;

    protected abstract void initializeCommands();
    public abstract void processCommand(MenuCommands cmd, ArrayList<String> args);

    public AbstractConsole() {
        consoleCommands = new HashMap<>();
        initializeCommands();
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        AbstractConsole.currentGame = currentGame;
    }

    public static void setBuilder(GameBuilder builder) {
        AbstractConsole.builder = builder;
    }

    protected ArrayList<String> generateUserInput() {
        String input = ConsoleServices.getStringInput("");
        String[] splice = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        Collections.addAll(argus, splice);
        return argus;
    }

    public boolean commandExists(String cmd) {
        return this.consoleCommands != null && this.consoleCommands.containsKey(cmd.toLowerCase());
    }

    protected void getUserInput() {
        String input = ConsoleServices.getStringInput("");
        String[] splited = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        Collections.addAll(argus, splited);
        while (argus.size() < 1) { argus = generateUserInput(); }
        findAndProcessCommand(argus);
    }


    public void findAndProcessCommand(ArrayList<String> args) {
        String command = args.remove(0).toLowerCase();
        if (commandExists(command)) {
            this.processCommand(this.consoleCommands.get(command), args);
        }
        else {
            runOnInvalidCommand(this);
        }
    }

    public void printPrompt(PromptMessage message, boolean promptForInput) {
        String promptString = GameStrings.getStringFromPromptType(message);
        ConsoleServices.print(promptString);
        if (promptForInput) {
            getUserInput();
        }
    }

    private void runOnInvalidCommand(AbstractConsole currentConsole) {
        ConsoleServices.print("Bad command! Please enter a valid command, or enter 'Help'.");
        if (currentConsole instanceof BiomeMenu) {
            BiomeMenu console = (BiomeMenu) this;
            console.printPrompt(PromptMessage.BIOME_MENU, true);
        }
        else if (currentConsole instanceof CustomDifficultyMenu) {
            CustomDifficultyMenu games = (CustomDifficultyMenu) this;
            games.printPrompt(PromptMessage.CUSTOM_DIFF_MENU, true);
        }
        else if (currentConsole instanceof DifficultyMenu) {
            DifficultyMenu stat = (DifficultyMenu) this;
            stat.printPrompt(PromptMessage.DIFF_MENU, true);
        }
        else if (currentConsole instanceof LoginMenu) {
            LoginMenu curr = (LoginMenu) this;
            curr.printPrompt(PromptMessage.LOGIN_MENU, true);
        }
        else if (currentConsole instanceof RaceMenu) {
            RaceMenu curr = (RaceMenu) this;
            curr.printPrompt(PromptMessage.RACE_MENU, true);
        }
        else if (currentConsole instanceof TurnMenu) {
            TurnMenu curr = (TurnMenu) this;
            curr.printPrompt(PromptMessage.TURN_MENU, true);
        }
    }


}
