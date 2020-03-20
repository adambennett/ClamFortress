package main.models.items.military.ammo;

import main.models.items.military.weapons.*;
import main.models.items.military.weapons.medieval.*;

public class FlamingArrows extends AbstractAmmo {

    public FlamingArrows() {
        super("Flaming Arrows", "Improves the damage of Bows by 500.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 500;
        }
        return 0;
    }

    @Override
    public FlamingArrows clone() {
        return new FlamingArrows();
    }
}
