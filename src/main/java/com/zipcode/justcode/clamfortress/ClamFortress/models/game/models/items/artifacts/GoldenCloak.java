package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class GoldenCloak extends AbstractArtifact implements Unique, Golden {

    public GoldenCloak() {
        super("Golden Cloak", "Improves Coin gain by 50%.");
    }

    @Override
    public GoldenCloak clone() {
        return new GoldenCloak();
    }

    @Override
    public Integer modifyGoldGain(int amt) {
        return amt;
    }

    @Override
    public Integer getGoldAmt() {
        return 200;
    }
}
