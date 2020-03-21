package main.models.managers;

import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.people.merchants.*;

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
