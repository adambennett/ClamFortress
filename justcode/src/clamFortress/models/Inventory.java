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
        return villageTools.contains(t);
    }
}
