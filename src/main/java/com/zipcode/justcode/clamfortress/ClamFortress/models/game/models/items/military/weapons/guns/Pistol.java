package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class Pistol extends AbstractGun {

    public Pistol() {
        super("Pistol", "Standard issue sidearm.", 12, 12, 80);
    }

    @Override
    public Pistol clone() {
        return new Pistol();
    }
}
