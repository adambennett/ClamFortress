package clamFortress;

import clamFortress.consoleIO.*;
import clamFortress.enums.*;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        new LoginMenu().printPrompt(PromptMessage.LOGIN_MENU, true);
    }
}
