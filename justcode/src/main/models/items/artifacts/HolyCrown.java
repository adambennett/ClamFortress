package main.models.items.artifacts;

import main.interfaces.*;
import main.models.items.*;

public class HolyCrown extends AbstractArtifact implements Unique {

    private static final Integer faithBonus = 15;

    public HolyCrown() {
        super("Holy Crown", "Improves your faith gain by 15.");
    }

    @Override
    public Integer modifyFaithInc() { return faithBonus; }

    @Override
    public HolyCrown clone() {
        return new HolyCrown();
    }
}
