package main.models;

import main.enums.*;
import main.interfaces.*;
import main.models.items.*;
import main.models.items.artifacts.AbstractArtifact;
import main.models.items.tools.*;
import main.models.items.tools.backpacks.*;
import main.models.managers.*;
import main.utilities.*;

import java.util.*;
import java.util.concurrent.*;

public class Inventory extends GameObject {

    private final Map<AbstractItem, Integer> inventory;
    private final Map<AbstractItem, Integer> priceMap;
    private Integer itemsHeld;
    private Integer capacity;

    public Inventory(int capacity) {
        super("Inventory", "A place to store all of your items.");
        this.capacity = capacity;
        this.inventory = new HashMap<>();
        this.priceMap = new HashMap<>();
        this.itemsHeld = 0;
    }

    public Integer inventorySize() {
        return itemsHeld;
    }

    public Integer getAmt(String item) {
        if (Archive.getInstance().isItem(item)) {
            return getAmt(Archive.getInstance().getItem(item));
        }
        return 0;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getAmt(AbstractItem item) {
        return this.inventory.getOrDefault(item, 0);
    }

    public Set<Map.Entry<AbstractItem, Integer>> getEntrySet() {
        return this.inventory.entrySet();
    }

    private Integer generateItemSellPrice(AbstractItem item) {
        if (this.priceMap.containsKey(item)) {
            return this.priceMap.get(item);
        } else{
            int roll = ThreadLocalRandom.current().nextInt(50, 1000);
            int costMod = Game.getDifficulty().getCostMod();
            int high = 200 * costMod;
            int low = 10 * costMod;
            int rollReduction = ThreadLocalRandom.current().nextInt(low, high);
            roll -= rollReduction;
            for (GameObject obj : Game.getModifierObjects()) {
                roll += obj.modifyItemSellPrice();
            }
            if (roll < 25) { roll = 25; }
            return roll;
        }
    }

    public Integer getItemValue(AbstractItem item) {
        return this.priceMap.getOrDefault(item, 0);
    }

    public Integer getItemValue(String name) {
        if (Archive.getInstance().isItem(name)) {
            return getItemValue(Archive.getInstance().getItem(name));
        }
        return 0;
    }

    public Boolean canAdd(AbstractItem item) {
        return (!(item instanceof Unique && inventory.containsKey(item)) && item.canObtain());
    }

    public Boolean addItem(AbstractItem item){
        if (inventorySize() < this.capacity || item instanceof AbstractBackpack) {
            if (canAdd(item)) {
                inventory.compute(item, (k,v) -> (v == null) ? 1 : v+1);
                item.onObtain();
                itemsHeld++;
                GameUtils.whenObtainingAnyItem(item);
                priceMap.put(item, generateItemSellPrice(item));
                if (item instanceof Golden) {
                    Game.getVillage().incCoins(((Golden) item).getGoldAmt());
                    OutputManager.addToBot("Received " + ((Golden) item).getGoldAmt() + " Coins upon pickup of Golden item! (" + item.getName() + ")");
                }

                if (item instanceof Cursed) {
                    ((Cursed) item).runCurse();
                    OutputManager.addToBot("You have been Cursed upon the pickup of a cursed item! (" + item.getName() + ")");
                }
                return true;
            }
        } else {
            OutputManager.addToBot(OutputFlag.INVENTORY_FULL, "Your inventory is full!");
        }
        return false;
    }

    public Boolean remove(AbstractItem item, int amt) {
        if (this.inventory.containsKey(item)) {
            inventory.compute(item, (k,v) -> (v != null) ? (v > amt) ? v - amt : 0 : 0);
            if (inventory.get(item) == 0) {
                inventory.remove(item);
            }
            return true;
        }
        return false;
    }

    public Boolean remove(String item, int amt) {
        item = item.toLowerCase();
        if (Archive.getInstance().isItem(item)) {
            AbstractItem ref = Archive.getInstance().getItem(item);
            return remove(ref, amt);
        }
        return false;
    }

    public Boolean containsItem(String name){
        return Archive.getInstance().get(name) != null && inventory.containsKey(Archive.getInstance().getItem(name));
    }

    public ArrayList<AbstractItem> getItems() {
        ArrayList<AbstractItem> items = new ArrayList<>();
        for (Map.Entry<AbstractItem, Integer> entry : inventory.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                items.add(entry.getKey().clone());
            }
        }
        return items;
    }

    public ArrayList<AbstractArtifact> getArtifacts() {
        ArrayList<AbstractArtifact> items = new ArrayList<>();
        for (Map.Entry<AbstractItem, Integer> entry : inventory.entrySet()) {
            if (entry.getKey() instanceof AbstractArtifact) {
                for (int i = 0; i < entry.getValue(); i++) {
                    items.add((AbstractArtifact) entry.getKey().clone());
                }
            }
        }
        return items;
    }

    public ArrayList<AbstractTool> getTools() {
        ArrayList<AbstractTool> items = new ArrayList<>();
        for (Map.Entry<AbstractItem, Integer> entry : inventory.entrySet()) {
            if (entry.getKey() instanceof AbstractTool) {
                for (int i = 0; i < entry.getValue(); i++) {
                    items.add((AbstractTool) entry.getKey().clone());
                }
            }
        }
        return items;
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
