package main.models.items.artifacts;

import main.interfaces.*;
import main.models.*;

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
