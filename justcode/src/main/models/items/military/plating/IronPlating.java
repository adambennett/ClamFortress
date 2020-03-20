package main.models.items.military.plating;

import main.models.items.military.armor.*;

public class IronPlating extends AbstractPlating {

    public IronPlating() {
        super("Bronze Plating", "Standard iron plate. Used to improve armor defense bonuses by 200.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 200;
    }

    @Override
    public IronPlating clone() {
        return new IronPlating();
    }
}
