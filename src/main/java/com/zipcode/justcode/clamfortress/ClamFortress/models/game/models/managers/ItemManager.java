package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;

import java.util.*;
import java.util.concurrent.*;

public class ItemManager {

    public static AbstractItem getRandomItem() {
        ArrayList<AbstractItem> items = new ArrayList<>(Archive.getInstance().items());
        return items.get(ThreadLocalRandom.current().nextInt(items.size()));
    }
}
