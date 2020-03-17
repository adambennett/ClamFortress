package main.models.managers;

import main.enums.*;
import main.utilities.*;

import java.util.*;

public class OutputManager {

    private static final ArrayList<String> outputPool;
    private static final ArrayList<OutputFlag> flags;

    static {
        outputPool = new ArrayList<>();
        flags = new ArrayList<>();
    }

    public static void reset() {
        outputPool.clear();
        flags.clear();
    }
    public static void addToBot(String message) {
        addToBot(message, OutputFlag.ALWAYS);
    }
    public static void addToTop(String message) {
        addToTop(message, OutputFlag.ALWAYS);
    }

    public static void addToBot(String message, OutputFlag flag) {
        if (!flags.contains(flag) || flag.equals(OutputFlag.ALWAYS)) {
            outputPool.add(message);
            flags.add(flag);
        }
    }
    public static void addToTop(String message, OutputFlag flag) {
        if (!flags.contains(flag) || flag.equals(OutputFlag.ALWAYS)) {
            outputPool.add(0, message);
            flags.add(flag);
        }
    }

    public static void print() {
        if (outputPool.size() > 0) {
            String toPrint = "";
            for (String s : outputPool) {
                toPrint += s + "\n";
            }
            toPrint = toPrint.trim();
            ConsoleServices.print("REPORT\n------\n");
            ConsoleServices.println(toPrint);
        }
    }

}
