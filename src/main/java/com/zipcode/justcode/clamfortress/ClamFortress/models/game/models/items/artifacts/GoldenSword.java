package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class GoldenSword extends AbstractArtifact implements Unique, Golden {

    private static final Integer atkBoost = 5;

    public GoldenSword() {
        super("Golden Sword", "Increases your attack by 5. Gives you 50 Gold on pickup.");
    }

    @Override
    public Integer modifyAtk() {
        return atkBoost;
    }

    @Override
    public GoldenSword clone() {
        return new GoldenSword();
    }

    @Override
    public Integer getGoldAmt() {
        return 50;
    }
}
