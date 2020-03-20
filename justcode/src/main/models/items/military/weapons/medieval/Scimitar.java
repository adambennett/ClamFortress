package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Scimitar extends AbstractWeapon {

    public Scimitar() {
        super("Scimitar", "A curved blade meant to be used for quick, slashing attacks. Improves attack by 90.");
    }

    @Override
    public Integer modifyAtk() {
        return 90;
    }

    @Override
    public Scimitar clone() {
        return new Scimitar();
    }
}
