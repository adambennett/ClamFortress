package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Sword extends AbstractWeapon {

    public Sword() {
        super("Sword", "A standard metal sword. Improves attack by 5.");
    }

    @Override
    public Integer modifyAtk() {
        return 5;
    }

    @Override
    public Sword clone() {
        return new Sword();
    }
}
