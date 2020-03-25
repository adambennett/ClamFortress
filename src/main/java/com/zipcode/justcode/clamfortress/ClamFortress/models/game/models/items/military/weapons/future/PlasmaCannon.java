package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.future;

public class PlasmaCannon extends AbstractFutureGun {

    public PlasmaCannon() {
        super("Plasma Cannon", "I don't know how it works, but this is a very big gun.", 6, 8000, 40);
    }

    @Override
    public PlasmaCannon clone() {
        return new PlasmaCannon();
    }
}
