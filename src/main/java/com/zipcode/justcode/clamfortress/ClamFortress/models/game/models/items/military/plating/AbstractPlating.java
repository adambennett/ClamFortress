package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public abstract class AbstractPlating extends AbstractMilitaryItem {
    public AbstractPlating(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyArmorDef(AbstractArmor armor);

    @Override
    public abstract AbstractPlating clone();
}
