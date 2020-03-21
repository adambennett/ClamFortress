package main.models.people.merchants;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.items.military.weapons.*;

import java.util.*;
import java.util.concurrent.*;

public class WeaponMerchant extends Merchant {

    public WeaponMerchant() {
        super();
    }

    @Override
    public Integer rollTurnsAvailable() {
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    @Override
    public Integer rollItemCount() {
        return ThreadLocalRandom.current().nextInt(3, 5);
    }

    @Override
    public void setupWares() {
        ArrayList<AbstractWeapon> allObjs = Archive.getInstance().weapons();
        while (getWares().size() < getItems()) {
            AbstractWeapon ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            while (getWares().containsKey(ref.getName().toLowerCase())) {
                ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            }
            getWares().put(ref.getName().toLowerCase(), ThreadLocalRandom.current().nextInt(100 * Game.getDifficulty().getCostMod(), 1000 * Game.getDifficulty().getCostMod()));
        }
    }

    @Override
    public String getMerchantType() {
        return "Weapon Merchant";
    }
}
