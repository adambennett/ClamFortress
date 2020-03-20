package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Caltrops extends AbstractWeapon {

    public Caltrops() {
        super("Caltrops", "A set of sharp nails meant to be used for area of denial attacks. Improves attack by 25.");
    }

    @Override
    public Integer modifyAtk() {
        return 25;
    }

    @Override
    public Caltrops clone() {
        return new Caltrops();
    }
}
