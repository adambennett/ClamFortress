package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

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
