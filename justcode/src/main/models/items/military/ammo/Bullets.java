package main.models.items.military.ammo;

import main.models.items.military.weapons.*;
import main.models.items.military.weapons.guns.*;

public class Bullets extends AbstractAmmo {

    public Bullets() {
        super("Bullets", "Improves the damage of Guns by 500.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof AbstractGun) {
            return 500;
        }
        return 0;
    }

    @Override
    public Bullets clone() {
        return new Bullets();
    }
}
