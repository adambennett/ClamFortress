package main.models.managers;

import main.enums.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.nodes.*;
import main.models.resources.natural.*;
import main.utilities.*;
import main.utilities.persistence.*;

import java.util.*;

public class OutputManager {

    private static final ArrayList<String> outputPool;
    private static final ArrayList<OutputFlag> flags;
    private static final Map<GameObject, Integer> collected;
    private static final Map<GameObject, Integer> consumed;
    private static final Map<AbstractNode, Integer> discovered;
    private static final ArrayList<AbstractBuilding> built;
    private static final ArrayList<AbstractBuilding> queued;
    private static Integer exp;
    private static Integer villagersMovedIn;
    private static Integer villagersMovedOut;
    private static Integer faminelosses;

    static {
        outputPool = new ArrayList<>();
        flags = new ArrayList<>();
        built = new ArrayList<>();
        queued = new ArrayList<>();
        collected = new HashMap<>();
        consumed = new HashMap<>();
        discovered = new HashMap<>();
        villagersMovedIn = 0;
        villagersMovedOut = 0;
        faminelosses = 0;
        exp = 0;
    }

    public static void reset() {
        outputPool.clear();
        flags.clear();
        villagersMovedIn = 0;
        villagersMovedOut = 0;
        faminelosses = 0;
        exp = 0;
    }

    public static void exp(int amt) { exp += amt; }

    public static void moveIn(int amt) { villagersMovedIn+=amt; }
    public static void moveOut(int amt) { villagersMovedOut+=amt; }
    public static void famineLoss(int amt) { faminelosses+=amt; }
    public static void consumed(GameObject obj, int amt) {
        consumed.compute(obj, GameUtils.getMapper(amt));
    }

    public static void consumed(GameObject obj) {
        consumed.compute(obj, GameUtils.getMapper());
    }

    public static void collected(GameObject obj, int amt) {
        collected.compute(obj, GameUtils.getMapper(amt));
    }

    public static void collected(GameObject obj) {
        collected.compute(obj, GameUtils.getMapper());
    }

    public static void discover(AbstractNode node, int amt) {
        discovered.compute(node, GameUtils.getNodeMapper(amt));
    }

    public static void discover(AbstractNode node) {
        discovered.compute(node, GameUtils.getNodeMapper());
    }

    public static void addToBot(String message) {
        addToBot(OutputFlag.ALWAYS, message);
    }
    public static void addToTop(String message) {
        addToTop(OutputFlag.ALWAYS, message);
    }

    public static void addToBot(OutputFlag flag, String message) {
        if (!flags.contains(flag) || flag.equals(OutputFlag.ALWAYS)) {
            outputPool.add(message);
            flags.add(flag);
        }
    }
    public static void addToTop(OutputFlag flag, String message) {
        if (!flags.contains(flag) || flag.equals(OutputFlag.ALWAYS)) {
            outputPool.add(0, message);
            flags.add(flag);
        }
    }

    public static Integer getExp() {
        return exp;
    }

    public static void print() {
        if (outputPool.size() > 0) {
            String reportString = "REPORT\n------\n";

            String extraTopLine = "";
            for (GameObject obj : Game.getModifierObjects()) {
                extraTopLine += obj.addToEndTurnReportTop();
            }


            LinkedHashMap<String, Integer> occ = new LinkedHashMap<>();

            for (String s : outputPool) { occ.compute(s, (k, v) -> (v==null) ? 1 : v+1); }

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
