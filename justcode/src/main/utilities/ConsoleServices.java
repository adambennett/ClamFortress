package main.utilities;

import java.util.*;

public final class ConsoleServices {

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String msg) {
        System.out.print(msg);
    }

    public static String getStringInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
