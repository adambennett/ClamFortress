package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.future;

public class GooCannon extends AbstractGooGun {

    public GooCannon() {
        super("Goo Cannon", "Stay gooey.", 0, 5000, 30);
    }

    @Override
    public GooCannon clone() {
        return new GooCannon();
    }
}
