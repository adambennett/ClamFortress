package main.models;

import main.interfaces.*;
import main.models.items.*;
import main.models.items.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<Tool> villageTools;
    private ArrayList<AbstractItem> items;

    public Inventory() {
        villageTools = new ArrayList<>();
    }

    public void addItem(AbstractItem item){
        if (!(item instanceof Unique && items.contains(item))) {
            items.add(item);
        }
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
