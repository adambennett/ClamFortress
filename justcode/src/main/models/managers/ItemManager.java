package main.models.managers;


import main.models.*;
import main.models.items.*;
import main.models.items.artifacts.*;

import java.util.*;
import java.util.concurrent.*;

public class ItemManager {

    public static AbstractItem getRandomItem() {
        ArrayList<AbstractItem> items = new ArrayList<>(Archive.getInstance().items());
        return items.get(ThreadLocalRandom.current().nextInt(items.size()));
    }
}
