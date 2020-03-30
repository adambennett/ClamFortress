package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

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
    private static Integer killed;
    private static Integer villagersKilled;
    private static Integer merchants;
    private static Integer damage;

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
        killed = 0;
        villagersKilled = 0;
        merchants = 0;
        exp = 0;
        damage = 0;
    }

    public static void reset() {
        outputPool.clear();
        flags.clear();
        villagersMovedIn = 0;
        villagersMovedOut = 0;
        faminelosses = 0;
        killed = 0;
        villagersKilled = 0;
        merchants = 0;
        exp = 0;
        damage = 0;
    }

    public static void dmg(int amt) { damage+=amt; }
    public static void merch(int amt) { merchants+=amt; }
    public static void exp(int amt) { exp += amt; }
    public static void kill(int amt) { killed+=amt; }
    public static void killVillager(int amt) { villagersKilled+=amt; }
    public static void moveIn(int amt) { villagersMovedIn+=amt; }
    public static void moveOut(int amt) { villagersMovedOut+=amt; }
    public static void famineLoss(int amt) { faminelosses+=amt; }
    public static void consumed(GameObject obj, int amt) {
        consumed.compute(obj, new Mapper<GameObject>(amt).mapper);
    }

    public static void consumed(GameObject obj) {
        consumed(obj, 1);
    }

    public static void collected(GameObject obj, int amt) {
        collected.compute(obj, new Mapper<GameObject>(amt).mapper);
    }

    public static void collected(GameObject obj) {
        collected(obj, 1);
    }

    public static void discover(AbstractNode node, int amt) {
        discovered.compute(node, new Mapper<AbstractNode>(amt).mapper);
    }

    public static void discover(AbstractNode node) {
        discover(node, 1);
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
            for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                extraTopLine += obj.addToEndTurnReportTop();
            }


            LinkedHashMap<String, Integer> occ = new LinkedHashMap<>();

            for (String s : outputPool) { occ.compute(s, new Mapper<String>(1).mapper); }

            String output = "";

            for (Map.Entry<String, Integer> entry : occ.entrySet()) {
                if (entry.getValue() > 1) {
                    output += entry.getKey() + " (x" + entry.getValue() + ")\n";
                } else {
                    output += entry.getKey() + "\n";
                }

            }
            output = output.trim();
            if (merchants > 0) { output += "\nNew Merchants: " + merchants; }
            if (villagersMovedIn > 0) { output += "\nNew Villagers: " + villagersMovedIn; }
            if (villagersMovedOut > 0) { output += "\nLost Villagers: " + villagersMovedOut; }
            if (faminelosses > 0) { output += "\nFamine Losses: " + faminelosses; }
            if (villagersKilled > 0) { output += "\nVillagers Killed: " + villagersKilled; }
            if (killed > 0) { output += "\nEnemies Killed: " + killed; }
            if (damage > 0) { output += "\nRaid Damage Dealt: " + damage; }
            for (Map.Entry<GameObject, Integer> entry : collected.entrySet()) {
                if (entry.getValue() > 0) {
                    output += "\nObtained " + entry.getValue() + " " + entry.getKey().getName();
                }
            }

            for (Map.Entry<GameObject, Integer> entry : consumed.entrySet()) {
                if (entry.getValue() > 0) {
                    output += "\nConsumed " + entry.getValue() + " " + entry.getKey().getName();
                }
            }

            String extraBotLine = "";
            for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                extraBotLine += obj.addToEndTurnReportBot();
            }

            ConsoleServices.print(reportString);
            if (!extraTopLine.equals("")) { ConsoleServices.println(extraTopLine); }
            ConsoleServices.println(output);
            if (!extraBotLine.equals("")) { ConsoleServices.println(extraBotLine); }
        }
    }

}
