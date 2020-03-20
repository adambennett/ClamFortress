package main.models.items.military.ammo;

import main.models.items.military.weapons.*;
import main.models.items.military.weapons.medieval.*;

public class IceArrows extends AbstractAmmo {

    public IceArrows() {
        super("Ice Arrows", "Improves the damage of Bows by 250.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 250;
        }
        return 0;
    }

    @Override
    public IceArrows clone() {
        return new IceArrows();
    }
}
