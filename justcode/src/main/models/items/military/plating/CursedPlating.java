package main.models.items.military.plating;

import main.interfaces.*;
import main.models.items.military.armor.*;

public class CursedPlating extends AbstractPlating implements Cursed {

    public CursedPlating() {
        super("Cursed Plating", "A very sturdy, metallic armor plating. It seems... off somehow? Improves armor defense bonuses by 666.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 666;
    }

    @Override
    public CursedPlating clone() {
        return new CursedPlating();
    }

    @Override
    public void runCurse() {

    }
}
