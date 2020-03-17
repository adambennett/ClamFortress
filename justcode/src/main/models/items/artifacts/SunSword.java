package main.models.items.artifacts;

import main.utilities.*;

public class SunSword extends AbstractArtifact {

    private static final Integer atkBoost = 15;

    public SunSword() {
        super("Sword Of The Morning");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }
}
