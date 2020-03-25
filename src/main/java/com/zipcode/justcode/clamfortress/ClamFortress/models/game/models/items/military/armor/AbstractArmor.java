package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.*;

public abstract class AbstractArmor extends AbstractMilitaryItem {
    public AbstractArmor(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyDef();

    @Override
    public abstract AbstractArmor clone();
}
