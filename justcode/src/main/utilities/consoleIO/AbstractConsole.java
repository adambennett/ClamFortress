package main.utilities.consoleIO;

import main.enums.*;
import main.interfaces.*;
import main.models.managers.*;
import main.utilities.*;
import main.utilities.builders.*;
import main.utilities.stringUtils.*;

import java.util.*;
import java.util.logging.*;

public abstract class AbstractConsole {

    protected static GameBuilder builder;
    protected Map<String, MenuCommands> consoleCommands;

    public abstract void initializeCommands();
    public abstract void processCommand(MenuCommands cmd, ArrayList<String> args);

    // Implement in multiline command processing consoles
    protected void postMultiline() {}

    public AbstractConsole() {
        consoleCommands = new HashMap<>();
        initializeCommands();
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

    protected void getUserInput(boolean multiline) {
        String input = ConsoleServices.getStringInput("");
        String[] splited = input.split("\\s+");
        ArrayList<String> argus = new ArrayList<>();
        Collections.addAll(argus, splited);
        while (argus.size() < 1) { argus = generateUserInput(); }
        if (multiline) {
            findAndProcessMultilineCommand(argus);
        } else {
            findAndProcessCommand(argus);
        }
    }


    public void findAndProcessCommand(ArrayList<String> args) {
        String command = args.remove(0).toLowerCase();
        if (command.equals("")) {
            runOnInvalidCommand(this);
            return;
        }
        if (GameManager.gameIsLoaded && !(this instanceof DevConsole) && command.length() > 0 && command.charAt(0) == '~') {
            AbstractConsole toReturnTo = this;
            if (this instanceof MidTurnMenu) {
                toReturnTo = new TurnMenu();
            }
            DevConsole dev = new DevConsole(toReturnTo);
            dev.printPrompt(PromptMessage.DEV_CONSOLE, true);
        } else if (commandExists(command)) {
            this.processCommand(this.consoleCommands.get(command), args);
        } else if (this instanceof DynamicConsole) {
            ((DynamicConsole) this).runDynamo(command, args);
        }
        else {
            runOnInvalidCommand(this);
        }
    }

    public void findAndProcessMultilineCommand(ArrayList<String> args) {
        String command = args.get(0).toLowerCase();
        if (GameManager.gameIsLoaded && !(this instanceof DevConsole) && command.length() > 0 && command.charAt(0) == '~') {
            AbstractConsole toReturnTo = this;
            if (this instanceof MidTurnMenu) {
                toReturnTo = new TurnMenu();
            }
            DevConsole dev = new DevConsole(toReturnTo);
            dev.printPrompt(PromptMessage.DEV_CONSOLE, true);
        } else {
            LinkedHashMap<String, ArrayList<String>> parsedCommands = new LinkedHashMap<>();
            for (int i = 0; i < args.size(); i++) {
                String cmdCheck = args.get(i);
                ArrayList<String> localArgs = new ArrayList<>();
                int otherIndex = i + 1;
                if (otherIndex < args.size()) {
                    localArgs.add(args.get(otherIndex));
                }
                if (parsedCommands.containsKey(cmdCheck)) {
                    ArrayList<String> newListOfArgs = parsedCommands.get(cmdCheck);
                    newListOfArgs.addAll(localArgs);
                    parsedCommands.put(cmdCheck, newListOfArgs);
                } else {
                    parsedCommands.put(cmdCheck, localArgs);
                    i++;
                }

            }
            boolean ranGoodCommand = false;
            for (Map.Entry<String, ArrayList<String>> entry : parsedCommands.entrySet()) {
                if (commandExists(entry.getKey())) {
                    this.processCommand(this.consoleCommands.get(entry.getKey()), entry.getValue());
                    ranGoodCommand = true;
                }
            }

            if (!ranGoodCommand) {
                runOnInvalidCommand(this);
            }
            postMultiline();
        }
    }

    public void printPrompt(PromptMessage message, boolean promptForInput) {
        printPrompt(message, promptForInput, false);
    }

    public void printPrompt(String actualMsg, boolean promptForInput) {
        ConsoleServices.println(actualMsg);
        if (promptForInput) {
            getUserInput(false);
        }
    }

    public void printPrompt(PromptMessage message, boolean promptForInput, boolean multiline) {
        String promptString = StringHelpers.getStringFromPromptType(message);
        ConsoleServices.println(promptString);
        if (promptForInput) {
            getUserInput(multiline);
        }
    }

    private void runOnInvalidCommand(AbstractConsole currentConsole) {
        if (currentConsole instanceof BiomeMenu) {
            BiomeMenu console = (BiomeMenu) this;
            console.printPrompt(PromptMessage.BIOME_MENU, false);
        }
        else if (currentConsole instanceof CustomDifficultyMenu) {
            CustomDifficultyMenu games = (CustomDifficultyMenu) this;
            games.printPrompt(PromptMessage.CUSTOM_DIFF_MENU, false);
        }
        else if (currentConsole instanceof DifficultyMenu) {
            DifficultyMenu stat = (DifficultyMenu) this;
            stat.printPrompt(PromptMessage.DIFF_MENU, false);
        }
        else if (currentConsole instanceof MainMenu) {
            MainMenu curr = (MainMenu) this;
            curr.printPrompt(PromptMessage.MAIN_MENU, false);
        }
        else if (currentConsole instanceof RaceMenu) {
            RaceMenu curr = (RaceMenu) this;
            curr.printPrompt(PromptMessage.RACE_MENU, false);
        }
        else if (currentConsole instanceof TurnMenu) {
            TurnMenu curr = (TurnMenu) this;
            curr.printPrompt(PromptMessage.TURN_MENU, false);
        }
        else if (currentConsole instanceof PriorityMenu) {
            PriorityMenu curr = (PriorityMenu) this;
            curr.printPrompt(PromptMessage.PRIORITY_MENU, false);
        }
        else if (currentConsole instanceof MidTurnMenu) {
            new TurnMenu().printPrompt(PromptMessage.TURN_MENU, false);
        }
        else if (currentConsole instanceof EndPhaseMenu) {
            EndPhaseMenu curr = (EndPhaseMenu) this;
            curr.printPrompt(PromptMessage.END_PHASE, false);
        }
        else if (currentConsole instanceof PopulationSetupMenu) {
            PopulationSetupMenu curr = (PopulationSetupMenu) this;
            curr.printPrompt(PromptMessage.POP_SETUP, false);
        }
        else if (currentConsole instanceof BoardSizeMenu) {
            BoardSizeMenu curr = (BoardSizeMenu) this;
            curr.printPrompt(PromptMessage.BOARD_SIZE, false);
        }
        else if (currentConsole instanceof NewGameHub) {
            NewGameHub curr = (NewGameHub) this;
            curr.printPrompt(PromptMessage.NEW_GAME_HUB, false);
        }
        else if (currentConsole instanceof LoginMenu) {
            LoginMenu curr = (LoginMenu) this;
            curr.printPrompt(PromptMessage.LOGIN, false);
        }
        else if (currentConsole instanceof SaleMerchantMenu) {
            new SaleMerchantMenu().printPrompt(PromptMessage.SALE_MERCHANT, false);
        }
        else if (currentConsole instanceof MerchantMenu) {
            new MerchantMenu().printPrompt(PromptMessage.MERCHANT, false);
        }
        else if (currentConsole instanceof TrainingMenu) {
           new TrainingMenu().printPrompt(PromptMessage.TRAINING, false);
        }
        else if (currentConsole instanceof StatsMenu) {
           new StatsMenu().printPrompt(PromptMessage.STATS_MENU, false);
        }
        else if (currentConsole instanceof StartingEraMenu) {
            new StartingEraMenu().printPrompt(PromptMessage.START_ERA, false);
        }
        printPrompt("Bad command! Please enter a valid command.", true);
    }

    public PromptMessage getMessageFromConsole(AbstractConsole con) {
        if (con instanceof BiomeMenu) {
            return PromptMessage.BIOME_MENU;
        }
        else if (con instanceof CustomDifficultyMenu) {
            return PromptMessage.CUSTOM_DIFF_MENU;
        }
        else if (con instanceof DifficultyMenu) {
            return PromptMessage.DIFF_MENU;
        }
        else if (con instanceof MainMenu) {
            return PromptMessage.MAIN_MENU;
        }
        else if (con instanceof RaceMenu) {
            return PromptMessage.RACE_MENU;
        }
        else if (con instanceof TurnMenu) {
            return PromptMessage.TURN_MENU;
        }
        else if (con instanceof PriorityMenu) {
            return PromptMessage.PRIORITY_MENU;
        }
        else if (con instanceof MidTurnMenu) {
            return PromptMessage.TURN_MENU;
        }
        else if (con instanceof EndPhaseMenu) {
            return PromptMessage.END_PHASE;
        }
        else if (con instanceof PopulationSetupMenu) {
            return PromptMessage.POP_SETUP;
        }
        else if (con instanceof BoardSizeMenu) {
            return PromptMessage.BOARD_SIZE;
        }
        else if (con instanceof NewGameHub || con instanceof MidConsoleMenu) {
            return PromptMessage.NEW_GAME_HUB;
        }
        else if (con instanceof LoginMenu) {
            return PromptMessage.LOGIN;
        }
        else if (con instanceof SaleMerchantMenu) {
            return PromptMessage.SALE_MERCHANT;
        }
        else if (con instanceof MerchantMenu) {
            return PromptMessage.MERCHANT;
        }
        else if (con instanceof TrainingMenu) {
            return PromptMessage.TRAINING;
        }
        else if (con instanceof StatsMenu) {
            return PromptMessage.STATS_MENU;
        }
        else if (con instanceof StartingEraMenu) {
            return PromptMessage.START_ERA;
        }
        return PromptMessage.TURN_MENU;
    }

    private Boolean setupGame() {
        Boolean toRet = builder.buildGame();
        Logger.getGlobal().info(builder.toString());
        return toRet;
    }

    private void advanceToFirstTurn() {
        printPrompt(PromptMessage.BLURB, false);
        TurnMenu turnMenu = new TurnMenu();
        turnMenu.printPrompt(PromptMessage.TURN_MENU, true);
    }

    public void beginGame() {
        if (builder.getStartingPopCap() < 5) {
            builder.setStartingPopCap(5);
        }
        boolean setup = setupGame();
        if (setup) {
            GameManager.gameIsLoaded = true;
            advanceToFirstTurn();
        } else {
            Logger.getGlobal().warning("Game was not created properly, returning to Main Menu");
            new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
        }
    }


}
