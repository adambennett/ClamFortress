package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Lance extends AbstractWeapon {

    public Lance() {
        super("Lance", "A standard metal lance. Improves attack by 75.");
    }

    @Override
    public Integer modifyAtk() {
        return 75;
    }

    @Override
    public Lance clone() {
        return new Lance();
    }
}
