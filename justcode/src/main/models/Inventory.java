package main.models;

import main.enums.*;
import main.interfaces.*;
import main.models.items.*;
import main.models.items.artifacts.AbstractArtifact;
import main.models.items.tools.*;
import main.models.managers.*;
import main.utilities.*;

import java.util.*;

public class Inventory extends GameObject {

    private final ArrayList<AbstractItem> items;
    private Integer capacity;

    public Inventory(int capacity) {
        super("Inventory", "A place to store all of your items.");
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public Boolean addItem(AbstractItem item){
        if (this.items.size() < this.capacity) {
            if (!(item instanceof Unique && items.contains(item))) {
                if (item.canObtain()) {
                    items.add(item);
                    item.onObtain();
                    GameUtils.whenObtainingAnyItem(item);
                    if (item instanceof Golden) {
                        Game.getVillage().setCoins(Game.getVillage().getCoins() + ((Golden) item).getGoldAmt());
                        OutputManager.addToBot("Received " + ((Golden) item).getGoldAmt() + " Coins upon pickup of Golden item! (" + item.getName() + ")");
                    }

                    if (item instanceof Cursed) {
                        ((Cursed) item).runCurse();
                        OutputManager.addToBot("You have been Cursed upon the pickup of a cursed item! (" + item.getName() + ")");
                    }
                    return true;
                }
            }
        } else {
            OutputManager.addToBot(OutputFlag.INVENTORY_FULL, "Your inventory is full!");
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

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
        if (this.capacity < 1) {
            this.capacity = 1;
        }
    }

    @Override
    public Inventory clone() {
        return new Inventory(this.capacity);
    }
}
