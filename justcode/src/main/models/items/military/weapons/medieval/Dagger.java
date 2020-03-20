package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Dagger extends AbstractWeapon {

    public Dagger() {
        super("Dagger", "A standard metal dagger. Improves attack by 1.");
    }

    @Override
    public Integer modifyAtk() {
        return 1;
    }

    @Override
    public Dagger clone() {
        return new Dagger();
    }
}
