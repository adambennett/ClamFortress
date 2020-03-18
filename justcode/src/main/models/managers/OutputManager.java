package main.models.managers;

import main.enums.*;
import main.models.*;
import main.models.items.*;
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
            String reportString = "REPORT\n------\n";

            String extraTopLine = "";
            for (GameObject obj : Game.getModifierObjects()) {
                extraTopLine += obj.addToEndTurnReportTop();
            }


            LinkedHashMap<String, Integer> occ = new LinkedHashMap<>();
            for (String s : outputPool) {
                if (occ.containsKey(s)) {
                    occ.put(s, occ.get(s) + 1);
                } else {
                    occ.put(s, 1);
                }
            }

            String output = "";
            for (Map.Entry<String, Integer> entry : occ.entrySet()) {
                if (entry.getValue() > 1) {
                    output += entry.getKey() + " (x" + entry.getValue() + ")\n";
                } else {
                    output += entry.getKey() + "\n";
                }

            }
            output = output.trim();

            String extraBotLine = "";
            for (GameObject obj : Game.getModifierObjects()) {
                extraBotLine += obj.addToEndTurnReportBot();
            }

            ConsoleServices.print(reportString);
            if (!extraTopLine.equals("")) { ConsoleServices.println(extraTopLine); }
            ConsoleServices.println(output);
            if (!extraBotLine.equals("")) { ConsoleServices.println(extraBotLine); }
        }
    }

}
