package main.models.items.artifacts;

import main.interfaces.*;

public class MoonShield extends AbstractArtifact implements Unique {

    private static final Integer defBoost = 15;

    public MoonShield() {
        super("Moon Shield", "Increases your defense by 15.");
    }

    @Override
    public Integer modifyDef() {
        return defBoost;
    }
}
