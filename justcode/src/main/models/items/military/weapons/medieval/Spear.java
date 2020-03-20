package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Spear extends AbstractWeapon {

    public Spear() {
        super("Spear", "A standard metal spear. Improves attack by 55.");
    }

    @Override
    public Integer modifyAtk() {
        return 55;
    }

    @Override
    public Spear clone() {
        return new Spear();
    }
}
