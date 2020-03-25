package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.plating;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.armor.*;

public class GoldPlating extends AbstractPlating implements Golden {

    public GoldPlating() {
        super("Gold Plating", "Brilliant Golden armor plates. Improve armor defense bonuses by 600. Worth 500 Coins upon pickup.");
    }

    @Override
    public Integer modifyArmorDef(AbstractArmor armor) {
        return 600;
    }

    @Override
    public GoldPlating clone() {
        return new GoldPlating();
    }

    @Override
    public Integer getGoldAmt() {
        return 500;
    }
}
