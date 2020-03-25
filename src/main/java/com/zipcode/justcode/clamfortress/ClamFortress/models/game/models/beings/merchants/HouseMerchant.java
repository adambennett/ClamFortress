package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;

import java.util.*;
import java.util.concurrent.*;

public class HouseMerchant extends Merchant {

    public HouseMerchant() {
        super();
    }

    @Override
    public Integer rollTurnsAvailable() {
        return ThreadLocalRandom.current().nextInt(1, 3);
    }

    @Override
    public void setupWares() {
        ArrayList<AbstractHouse> allObjs = Archive.getInstance().houses();
        while (getWares().size() < getItems()) {
            AbstractHouse ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            while (getWares().containsKey(ref.getName().toLowerCase())) {
                ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            }
            getWares().put(ref.getName().toLowerCase(), ThreadLocalRandom.current().nextInt(100 * Game.getDifficulty().getCostMod(), 1000 * Game.getDifficulty().getCostMod()));
        }
    }

    @Override
    public String getMerchantType() {
        return "House Merchant";
    }
}
