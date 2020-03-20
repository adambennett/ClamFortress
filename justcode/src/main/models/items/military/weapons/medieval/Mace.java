package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Mace extends AbstractWeapon {

    public Mace() {
        super("Mace", "A standard metal mace. Improves attack by 75.");
    }

    @Override
    public Integer modifyAtk() {
        return 75;
    }

    @Override
    public Mace clone() {
        return new Mace();
    }
}
