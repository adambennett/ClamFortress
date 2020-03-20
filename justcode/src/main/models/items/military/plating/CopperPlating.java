package main.models.items.military.plating;

import main.models.items.military.armor.*;

public class CopperPlating extends AbstractPlating {

    public CopperPlating() {
        super("Copper Plating", "Simple copper plate. Used to improve armor defense bonuses by 150.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 150;
    }

    @Override
    public CopperPlating clone() {
        return new CopperPlating();
    }
}
