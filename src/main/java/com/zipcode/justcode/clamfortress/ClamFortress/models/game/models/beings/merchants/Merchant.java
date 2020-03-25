package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

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
        this.items = rollItemCount();
        this.turnsAvailable = rollTurnsAvailable();
        setupWares();
    }

    public Integer rollTurnsAvailable() {
        return ThreadLocalRandom.current().nextInt(1, 4);
    }

    private Integer rollItemCount() {
        return ThreadLocalRandom.current().nextInt(3, GameManager.getInstance().getMerchantItems());
    }

    public void setupWares() {
        ArrayList<GameObject> allObjs = Archive.getInstance().getArchive();
        while (wares.size() < items) {
            GameObject ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            while (wares.containsKey(ref.getName().toLowerCase()) || (ref instanceof AbstractAnimal)) {
                ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            }
            wares.put(ref.getName().toLowerCase(), ThreadLocalRandom.current().nextInt(100 * Game.getDifficulty().getCostMod(), 1000 * Game.getDifficulty().getCostMod()));
        }
    }

    public void purchase(String key, int amtPaid) {
        this.wares.remove(key.toLowerCase());
        for (GameObject obj : Game.getModifierObjects()) {
            obj.onPurchaseItem(Archive.getInstance().get(key), amtPaid);
        }
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

    public Boolean contains(String item) {
        return wares.containsKey(item) || wares.containsKey(item.toLowerCase()) || wares.containsKey(item.toUpperCase()) || wares.containsKey(StringHelpers.capFirstLetter(item.toLowerCase()));
    }

    public String getMerchantType() {
        return "Traveling Merchant";
    }

    public Integer getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
