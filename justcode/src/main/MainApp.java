package main;

import main.consoleIO.*;
import main.enums.*;

public class MainApp {

    public static void main(String[] args) {
        new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
    }
}
