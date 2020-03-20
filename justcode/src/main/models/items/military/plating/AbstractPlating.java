package main.models.items.military.plating;

import main.models.items.military.*;
import main.models.items.military.armor.*;

public abstract class AbstractPlating extends AbstractMilitaryItem {
    public AbstractPlating(String name, String desc) {
        super(name, desc);
    }

    @Override
    public abstract Integer modifyArmorDef(AbstractArmor armor);

    @Override
    public abstract AbstractPlating clone();
}
