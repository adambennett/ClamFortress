package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class Shotgun extends AbstractGun {

    public Shotgun() {
        super("Combat Shotgun", "Spray and pray baby!", 12, 80, 20);
    }

    @Override
    public Shotgun clone() {
        return new Shotgun();
    }
}
