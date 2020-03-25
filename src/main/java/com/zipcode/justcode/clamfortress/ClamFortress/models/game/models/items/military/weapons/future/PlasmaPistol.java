package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.future;

public class PlasmaPistol extends AbstractFutureGun {

    public PlasmaPistol() {
        super("Plasma Pistol", "Looks like a little pea shooter!", 12, 10, 85);
    }

    @Override
    public PlasmaPistol clone() {
        return new PlasmaPistol();
    }
}
