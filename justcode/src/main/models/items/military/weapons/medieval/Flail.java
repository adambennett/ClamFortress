package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Flail extends AbstractWeapon {

    public Flail() {
        super("Flail", "A standard metal flail. Improves attack by 80.");
    }

    @Override
    public Integer modifyAtk() {
        return 80;
    }

    @Override
    public Flail clone() {
        return new Flail();
    }
}
