package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class SCAR extends AbstractGun {

    public SCAR() {
        super("SCAR", "Standard issue SCAR-H.", 36, 48, 70);
    }

    @Override
    public SCAR clone() {
        return new SCAR();
    }
}
