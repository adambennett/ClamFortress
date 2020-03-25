package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;

import java.util.*;
import java.util.concurrent.*;

public class ItemManager {

    public static AbstractItem getRandomItem() {
        ArrayList<AbstractItem> items = new ArrayList<>(Archive.getInstance().items());
        return items.get(ThreadLocalRandom.current().nextInt(items.size()));
    }
}
