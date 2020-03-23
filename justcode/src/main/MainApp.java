package main;

import main.models.*;
import main.models.managers.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;
import main.utilities.*;
import main.utilities.consoleIO.*;
import main.enums.*;
import main.utilities.persistence.*;

import java.util.*;

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
