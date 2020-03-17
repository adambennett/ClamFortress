package main;

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
        new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
    }

}
