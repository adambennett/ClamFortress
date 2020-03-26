package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class LoginMenu extends AbstractConsole {

    @Override
    public void initializeCommands() {
        consoleCommands.put("1", MenuCommands.LOGIN);
        consoleCommands.put("2", MenuCommands.REGISTER);
        consoleCommands.put("3", MenuCommands.CONTINUE);
        consoleCommands.put("0", MenuCommands.EXIT);
    }

    @Override
    public void processCommand(MenuCommands cmd, ArrayList<String> args) {
        switch (cmd) {
            case LOGIN:
                String user = ConsoleServices.getStringInput("Username: ");
                String pass = ConsoleServices.getStringInput("Password: ");
                if (Database.logIn(user, pass)) {
                    MainMenu main = new MainMenu();
                    main.printPrompt(PromptMessage.MAIN_MENU, false);
                    main.printPrompt("Welcome back, " + user + ".", true);
                } else {
                    printPrompt(PromptMessage.LOGIN, false);
                    printPrompt("Invalid credentials.", true);
                }
                break;
            case REGISTER:
                String userR = ConsoleServices.getStringInput("New Username: ");
                String passR = ConsoleServices.getStringInput("Password: ");
                if (!Database.isUser(userR)) {
                    Database.registerUser(userR, passR);
                    Database.logIn(userR, passR);
                    MainMenu main = new MainMenu();
                    main.printPrompt("Registered new user " + userR, false);
                    main.printPrompt(PromptMessage.MAIN_MENU, true);
                } else {
                    printPrompt(PromptMessage.LOGIN, false);
                    printPrompt("User already exists!", true);
                }
                break;
            case EXIT:
                System.exit(0);
            case CONTINUE:
                Database.logInQuickplay();
                builder = new GameBuilder();
                builder.setStartingPop(2000);
                builder.setStartingPopCap(2500);
                builder.setxMax(50);
                builder.setyMax(50);
                builder.buildGame();
                beginGame();
                break;
        }
    }
}
