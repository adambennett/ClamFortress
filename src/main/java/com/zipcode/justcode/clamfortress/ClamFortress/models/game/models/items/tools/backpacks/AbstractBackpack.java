package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;

public abstract class AbstractBackpack extends AbstractItem {
    public AbstractBackpack(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract AbstractBackpack clone();
}
