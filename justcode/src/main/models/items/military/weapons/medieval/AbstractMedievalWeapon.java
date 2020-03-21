package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;
import main.models.tech.*;
import main.models.tech.eras.*;

public abstract class AbstractMedievalWeapon extends AbstractWeapon {
    public AbstractMedievalWeapon(String name, String desc) {
        super(name, desc);
    }

    @Override
    public Boolean canObtain() {
        Era check = TechTree.getEraFromString("Bronze Age");
        if (check != null) {
            return TechTree.getCurrentEra().atLeast(check);
        }
        return false;
    }

    @Override
    public abstract Integer modifyAtk();

    @Override
    public abstract AbstractWeapon clone();
}
