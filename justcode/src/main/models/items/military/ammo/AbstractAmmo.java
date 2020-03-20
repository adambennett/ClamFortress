package main.models.items.military.ammo;

import main.models.items.military.*;
import main.models.items.military.weapons.*;

public abstract class AbstractAmmo extends AbstractMilitaryItem {
    public AbstractAmmo(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyWeaponDmg(AbstractWeapon weapon);

    @Override
    public abstract AbstractAmmo clone();
}
