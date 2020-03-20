package main.models.items.military.plating;

import main.models.items.military.armor.*;

public class GemPlating extends AbstractPlating {

    public GemPlating() {
        super("Gem Plating", "Amazing armor plating crafted from rare gems. Improve armor defense bonuses by 325.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 325;
    }

    @Override
    public GemPlating clone() {
        return new GemPlating();
    }
}
