package main;

import main.utilities.*;
import main.utilities.consoleIO.*;
import main.enums.*;
import main.utilities.persistence.*;

public class MainApp {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.initialize();
    }

    public void initialize() {
        Database.loadDatabase();
        GameStrings.initModMap();
        new MainMenu().printPrompt(PromptMessage.MAIN_MENU, true);
    }

}
