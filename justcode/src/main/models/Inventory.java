package main.models;

import main.models.artifacts.AbstractArtifact;
import main.models.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<Tool> villageTools;

    public Inventory() {
        villageTools = new ArrayList<>();
    }

    public void addTool(Tool t) {
        villageTools.add(t);
    }

    public Boolean containsTool(Tool t) {
        for (Tool tool : villageTools) {
            if (t.getClass().equals(tool.getClass())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "villageTools=" + villageTools +
                '}';
    }
}
