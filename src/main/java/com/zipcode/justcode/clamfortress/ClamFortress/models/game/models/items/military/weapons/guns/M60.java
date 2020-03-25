package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class M60 extends AbstractGun {

    public M60() {
        super("M60", "Bringing out the big guns.", 400, 400, 55);
    }

    @Override
    public M60 clone() {
        return new M60();
    }
}
