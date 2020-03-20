package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public abstract class AbstractMedievalWeapon extends AbstractWeapon {
    public AbstractMedievalWeapon(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyAtk();

    @Override
    public abstract AbstractWeapon clone();
}
