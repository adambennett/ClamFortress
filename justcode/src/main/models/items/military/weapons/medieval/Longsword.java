package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Longsword extends AbstractWeapon {

    public Longsword() {
        super("Longsword", "A standard metal longsword. Improves attack by 100.");
    }

    @Override
    public Integer modifyAtk() {
        return 100;
    }

    @Override
    public Longsword clone() {
        return new Longsword();
    }
}
