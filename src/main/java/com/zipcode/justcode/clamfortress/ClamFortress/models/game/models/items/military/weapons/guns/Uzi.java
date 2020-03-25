package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class Uzi extends AbstractGun {

    public Uzi() {
        super("Uzi", "Mobster style.", 22, 22, 22);
    }

    @Override
    public Uzi clone() {
        return new Uzi();
    }
}
