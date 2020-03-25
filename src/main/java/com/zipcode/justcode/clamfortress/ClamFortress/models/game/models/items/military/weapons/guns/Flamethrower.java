package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class Flamethrower extends AbstractGun {

    public Flamethrower() {
        super("Flamethrower", "My god...", 10, 100, 100);
    }

    @Override
    public Flamethrower clone() {
        return new Flamethrower();
    }
}
