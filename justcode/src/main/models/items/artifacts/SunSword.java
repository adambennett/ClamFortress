package main.models.items.artifacts;

import main.interfaces.*;
import main.utilities.*;

public class SunSword extends AbstractArtifact implements Unique {

    private static final Integer atkBoost = 15;

    public SunSword() {
        super("Sword Of The Morning", "Increases your attack by 15.");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }

    @Override
    public SunSword clone() {
        return new SunSword();
    }
}
