package main.models.managers;

import main.utilities.*;

import java.util.*;

public class OutputManager {

    private static ArrayList<String> outputPool;

    static { reset(); }

    public static void reset() { outputPool = new ArrayList<>(); }
    public static void addToBottom(String message) {
        outputPool.add(message);
    }
    public static void addToTop(String message) {
        outputPool.add(0, message);
    }

    public static void print() {
        String toPrint = "";
        for (String s : outputPool) {
            toPrint += s + "\n";
        }
        toPrint = toPrint.trim();
        ConsoleServices.print("REPORT\n------\n");
        ConsoleServices.println(toPrint.toString());
    }

}
