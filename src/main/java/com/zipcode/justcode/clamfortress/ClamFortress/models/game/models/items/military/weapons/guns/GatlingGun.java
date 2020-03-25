package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class GatlingGun extends AbstractGun {

    public GatlingGun() {
        super("Gatling Gun", "A huge shooty boy.", 20000, 50, 10);
    }

    @Override
    public GatlingGun clone() {
        return new GatlingGun();
    }
}
