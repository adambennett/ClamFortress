package main.models;

import main.interfaces.*;
import main.models.items.*;
import main.models.items.artifacts.AbstractArtifact;
import main.models.items.tools.*;

import java.util.*;

public class Inventory {

    private ArrayList<AbstractItem> items;

    public Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(AbstractItem item){
        if (!(item instanceof Unique && items.contains(item))) {
            items.add(item);
        }
    }

    public Boolean containsItem(AbstractItem t) {
        for (AbstractItem item : items) {
            if (item.getName().equals(t.getName())) {
                return true;
            }
        }
        return false;
    }

    public Boolean containsItem(String name){
        for (AbstractItem item : items) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<AbstractItem> getItems() {
        return items;
    }

    public ArrayList<AbstractArtifact> getArtifacts() {
        ArrayList<AbstractArtifact> arts = new ArrayList<>();
        for (AbstractItem i : items) {
            if (i instanceof AbstractArtifact) {
                arts.add((AbstractArtifact) i);
            }
        }
        return arts;
    }

    public ArrayList<AbstractTool> getTools() {
        ArrayList<AbstractTool> arts = new ArrayList<>();
        for (AbstractItem i : items) {
            if (i instanceof AbstractTool) {
                arts.add((AbstractTool) i);
            }
        }
        return arts;
    }

    @Override
    public String toString() {
        String itemString = "";
        for (AbstractItem i : items) {
            itemString += i.getName() + ", ";
        }
        itemString = itemString.substring(0, itemString.length()-2);
        return "Inventory{" +
                "items=" + itemString +
                '}';
    }

}
