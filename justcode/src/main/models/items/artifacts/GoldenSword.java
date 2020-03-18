package main.models.items.artifacts;

import main.interfaces.*;

public class GoldenSword extends AbstractArtifact implements Unique, Golden {

    private static final Integer goldAmt = 50;
    private static final Integer atkBoost = 5;

    public GoldenSword() {
        super("Golden Sword", "Increases your attack by 5. Gives you 50 Gold on pickup.");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }

    @Override
    public Integer getGoldAmt() {
        return 50;
    }
}
