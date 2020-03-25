package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor;

public class Hoody extends AbstractArmor {

    public Hoody() {
        super("Hoody", "Doesn't do much to keep your villagers safe, but it keeps them warm! Improves your defense by 10.");
    }

    @Override
    public Integer modifyDef() {
        return 10;
    }

    @Override
    public Hoody clone() {
        return new Hoody();
    }
}
