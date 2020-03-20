package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Rapier extends AbstractWeapon {

    public Rapier() {
        super("Rapier", "A thin, jabby sword. Poke 'em with the pointy end! Improves attack by 95.");
    }

    @Override
    public Integer modifyAtk() {
        return 95;
    }

    @Override
    public Rapier clone() {
        return new Rapier();
    }
}
