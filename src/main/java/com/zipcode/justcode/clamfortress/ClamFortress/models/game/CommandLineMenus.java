package com.zipcode.justcode.clamfortress.ClamFortress.models.game;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;

public class CommandLineMenus {

    public static void main(String[] args) {
        CommandLineMenus commandLineMenus = new CommandLineMenus();
        commandLineMenus.initialize();
    }

    public void initialize() {
        new LoginMenu().printPrompt(PromptMessage.LOGIN, true);
    }

}
