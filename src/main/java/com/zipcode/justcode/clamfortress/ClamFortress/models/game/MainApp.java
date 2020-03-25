package com.zipcode.justcode.clamfortress.ClamFortress.models.game;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class MainApp {

    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.initialize();
    }

    public void initialize() {
        Database.loadDatabase();
        new LoginMenu().printPrompt(PromptMessage.LOGIN, true);
    }

}
