package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class GoldenBow extends Bow implements Projectile, Golden, Unique {

    public GoldenBow() {
        super("Golden Bow", "A Golden bow. Improves attack by 50.");
        this.ammoCount = 50;
        this.damage = 40;
        this.shots = 0;
        this.accuracy = 95;
    }

    @Override
    public Integer modifyAtk() {
        return 50;
    }

    @Override
    public Integer getGoldAmt() { return 100; }

    @Override
    public GoldenBow clone() {
        return new GoldenBow();
    }

}
