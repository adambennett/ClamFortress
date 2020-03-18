package main.models;

import main.enums.*;
import main.interfaces.*;
import main.models.items.*;
import main.models.items.artifacts.AbstractArtifact;
import main.models.items.tools.*;
import main.models.managers.*;

import java.util.*;

public class Inventory {

    private ArrayList<AbstractItem> items;
    private Integer size;

    public Inventory(int size) {
        this.items = new ArrayList<>();
        this.size = size;
    }

    public void addItem(AbstractItem item){
        if (this.items.size() < this.size) {
            if (!(item instanceof Unique && items.contains(item))) {
                items.add(item);
                if (item instanceof Golden) {
                    Game.getVillage().setCoins(Game.getVillage().getCoins() + ((Golden) item).getGoldAmt());
                    OutputManager.addToBot("Received " + ((Golden) item).getGoldAmt() + " Coins upon pickup of Golden object!");
                }

                if (item instanceof Cursed) {
                    ((Cursed) item).runCurse();
                    OutputManager.addToBot("You have been Cursed upon the pickup of a cursed item!");
                }
            }
        } else {
            OutputManager.addToBot("Your inventory is full!", OutputFlag.INVENTORY_FULL);
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

    public void setSize(Integer size) {
        this.size = size;
        if (this.size < 1) {
            this.size = 1;
        }
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
