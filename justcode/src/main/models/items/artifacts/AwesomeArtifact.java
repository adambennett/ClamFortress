package main.models.items.artifacts;

import main.interfaces.*;

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
    public Integer modifyFaithInc() { return faithBoost; }
}
