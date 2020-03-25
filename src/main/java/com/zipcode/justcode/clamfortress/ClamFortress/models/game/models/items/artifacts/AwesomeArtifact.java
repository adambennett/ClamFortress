package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class AwesomeArtifact extends AbstractArtifact implements Unique {

    private static final Integer atkBoost = 10;
    private static final Integer defBoost = 10;
    private static final Integer faithBoost = 5;

    public AwesomeArtifact() {
        super("Awesome Artifact", "Improves your attack, defense and faith gain by 10/10/5.");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }

    @Override
    public Integer modifyDef() {
        return defBoost;
    }

    @Override
    public AwesomeArtifact clone() {
        return new AwesomeArtifact();
    }

    @Override
    public Integer modifyFaithInc() { return faithBoost; }
}
