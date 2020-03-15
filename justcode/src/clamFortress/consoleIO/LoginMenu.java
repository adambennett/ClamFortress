package clamFortress.consoleIO;

import clamFortress.enums.*;
import clamFortress.utilities.builders.*;

import java.util.*;

public class LoginMenu extends AbstractConsole  {

    @Override
    protected void initializeCommands() {
        consoleCommands.put("1", MenuCommands.NEW_GAME);
        consoleCommands.put("2", MenuCommands.LOAD_GAME);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case NEW_GAME:
                setBuilder(new GameBuilder());
                DifficultyMenu diff = new DifficultyMenu();
                diff.printPrompt(PromptMessage.DIFF_MENU, true);
                return;
            /*case LOAD_GAME:
                // Database.loadGameStuff();
                // this.setCurrentGame(Database.theGameWeLoaded);
                // resume game
                return;
            */
        }
    }

}
