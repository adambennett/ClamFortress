package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.future;

public class ShockwaveCannon extends AbstractFutureGun {

    public ShockwaveCannon() {
        super("Shockwave Cannon", "This seems neat.", 60, 500, 45);
    }

    @Override
    public ShockwaveCannon clone() {
        return new ShockwaveCannon();
    }
}
