package main.models.items.military.ammo;

import main.models.items.military.weapons.*;
import main.models.items.military.weapons.medieval.*;

public class PoisonArrows extends AbstractAmmo {

    public PoisonArrows() {
        super("Poison Arrows", "Improves the damage of Bows by 300.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof Bow) {
            return 300;
        }
        return 0;
    }

    @Override
    public PoisonArrows clone() {
        return new PoisonArrows();
    }
}
