package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class ShopToken extends AbstractArtifact implements Unique {

    public ShopToken() {
        super("Shop Token", "Improves the chance to encounter Merchants while Scouting.");
    }


    @Override
    public ShopToken clone() {
        return new ShopToken();
    }
}
