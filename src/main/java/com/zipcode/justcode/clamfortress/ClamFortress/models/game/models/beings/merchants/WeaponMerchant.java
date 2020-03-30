package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

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
    public void setupWares() {
        ArrayList<AbstractWeapon> allObjs = Archive.getInstance().weapons();
        while (getWares().size() < getItems()) {
            AbstractWeapon ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            while (getWares().containsKey(ref.getName().toLowerCase())) {
                ref = allObjs.get(ThreadLocalRandom.current().nextInt(allObjs.size()));
            }
            getWares().put(ref.getName().toLowerCase(), ThreadLocalRandom.current().nextInt(100 * Database.getCurrentGame().getDifficulty().getCostMod(), 1000 * Database.getCurrentGame().getDifficulty().getCostMod()));
        }
    }

    @Override
    public String getMerchantType() {
        return "Weapon Merchant";
    }
}
