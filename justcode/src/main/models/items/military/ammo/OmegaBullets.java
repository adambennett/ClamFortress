package main.models.items.military.ammo;

import main.models.items.military.weapons.*;
import main.models.items.military.weapons.guns.*;

public class OmegaBullets extends AbstractAmmo {

    public OmegaBullets() {
        super("Omega Bullets", "Improves the damage of Guns by 5000.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof AbstractGun) {
            return 5000;
        }
        return 0;
    }

    @Override
    public OmegaBullets clone() {
        return new OmegaBullets();
    }
}
