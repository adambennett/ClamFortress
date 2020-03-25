package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.merchants.*;

import java.util.*;
import java.util.concurrent.*;

public class MerchantManager {

    public static Merchant getRandomMerchant() {
        ArrayList<Merchant> shopkeepers = new ArrayList<>();
        shopkeepers.add(new Merchant());
        shopkeepers.add(new HouseMerchant());
        shopkeepers.add(new WeaponMerchant());
        return shopkeepers.get(ThreadLocalRandom.current().nextInt(shopkeepers.size()));
    }

}
