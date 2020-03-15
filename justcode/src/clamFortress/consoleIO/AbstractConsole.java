package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.game.*;

import java.util.*;

public abstract class AbstractConsole {

    protected static Game currentGame;
    protected Map<String, MenuCommands> consoleCommands;

    public abstract void processCommand(MenuCommands cmd, ArrayList<String> args);
    protected abstract void initializeCommands();

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
}
