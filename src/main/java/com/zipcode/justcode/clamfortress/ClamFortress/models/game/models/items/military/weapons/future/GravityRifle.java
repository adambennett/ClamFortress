package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.future;

public class GravityRifle extends AbstractFutureGun {

    public GravityRifle() {
        super("Gravity Rifle", "It shoots gravity? How?", 10, 10000, 25);
    }

    @Override
    public GravityRifle clone() {
        return new GravityRifle();
    }
}
