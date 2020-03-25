package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class MoonShield extends AbstractArtifact implements Unique {

    private static final Integer defBoost = 15;

    public MoonShield() {
        super("Moon Shield", "Increases your defense by 15.");
    }

    @Override
    public Integer modifyDef() {
        return defBoost;
    }

    @Override
    public MoonShield clone() {
        return new MoonShield();
    }
}
