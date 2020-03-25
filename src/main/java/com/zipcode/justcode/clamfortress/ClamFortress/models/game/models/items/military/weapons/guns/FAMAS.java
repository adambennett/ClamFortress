package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class FAMAS extends AbstractGun {

    public FAMAS() {
        super("FAMAS", "Standard issue FAMAS.", 72, 200, 36);
    }

    @Override
    public FAMAS clone() {
        return new FAMAS();
    }
}
