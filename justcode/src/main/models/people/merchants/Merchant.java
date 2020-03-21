package main.models.people.merchants;

import main.models.*;
import main.models.managers.*;
import main.utilities.stringUtils.*;

import java.util.*;
import java.util.concurrent.*;

public class Merchant {

    private final Map<String, Integer> wares;
    private final Integer turnsAvailable;
    private final Integer items;
    private final String name;
    private Integer turnsVisited;

    public Merchant() {
        this.turnsVisited = 0;
        this.wares = new HashMap<>();
        this.name = GameStrings.getRandomName(false);
        this.items = ThreadLocalRandom.current().nextInt(3, 9);
        this.turnsAvailable = ThreadLocalRandom.current().nextInt(1, 6);
        ArrayList<GameObject> allObjs = Archive.getInstance().getArchive();
        while (wares.size() < items) {
            GameObject ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            while (wares.containsKey(ref.getName().toLowerCase())) {
                ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            }
            wares.put(ref.getName(), ThreadLocalRandom.current().nextInt(100 * Game.getDifficulty().getCostMod(), 1000 * Game.getDifficulty().getCostMod()));
        }
    }

    public void purchase(String key) {
        this.wares.remove(key);
    }

    public void visit() {
        this.turnsVisited++;
        if (this.turnsVisited >= this.turnsAvailable || this.wares.size() < 1) {
            Game.getVillage().getVistingMerchants().remove(this);
            OutputManager.addToBot("Merchant " + name + " has left the region.");
        } else {
            OutputManager.addToBot("Merchant " + name + " will stick around for " + (this.turnsAvailable - this.turnsVisited) + " more turns.");
        }
    }

    public Map<String, Integer> getWares() {
        return wares;
    }

    public Integer getTurnsAvailable() {
        return turnsAvailable;
    }

    public Integer getTurnsVisited() {
        return turnsVisited;
    }

    public Integer getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
