package clamFortress.models;

import clamFortress.models.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<Tool> villageTools;

    public Inventory() {
        villageTools = new ArrayList<>();
    }

    public void addTool(Tool t) {
        villageTools.add(t);
    }

    public Boolean contains(Tool t) {
        for (Tool tool : villageTools) {
            if (t.getClass().equals(tool.getClass())) {
                return true;
            }
        }
        return false;
    }
}
