package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor;

import java.util.concurrent.*;

public class GooSuit extends AbstractArmor {

    public GooSuit() {
        super("Goo Suit", "Some sort of weird.. goo outfit? Maybe this will keep your villagers safe.");
    }

    @Override
    public Integer modifyDef() {
        return ThreadLocalRandom.current().nextInt(100, 2000);
    }

    @Override
    public GooSuit clone() {
        return new GooSuit();
    }
}
