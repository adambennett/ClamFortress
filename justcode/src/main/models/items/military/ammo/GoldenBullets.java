package main.models.items.military.ammo;

import main.interfaces.*;
import main.models.items.military.weapons.*;
import main.models.items.military.weapons.guns.*;

public class GoldenBullets extends AbstractAmmo implements Golden {

    public GoldenBullets() {
        super("Bullets", "Improves the damage of Guns by 1500. Worth 125 Coins upon pickup.");
    }

    @Override
    public Integer modifyWeaponDmg(AbstractWeapon weapon) {
        if (weapon instanceof AbstractGun) {
            return 1500;
        }
        return 0;
    }

    @Override
    public GoldenBullets clone() {
        return new GoldenBullets();
    }

    @Override
    public Integer getGoldAmt() {
        return 125;
    }
}
