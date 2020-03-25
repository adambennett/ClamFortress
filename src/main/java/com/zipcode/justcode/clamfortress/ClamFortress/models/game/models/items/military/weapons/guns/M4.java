package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class M4 extends AbstractGun {

    public M4() {
        super("M4", "Standard issue M4.", 24, 16, 85);
    }

    @Override
    public M4 clone() {
        return new M4();
    }
}
