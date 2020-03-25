package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class FAL extends AbstractGun {

    public FAL() {
        super("FAL", "Semi-automatic and highly deadly.", 12, 1200, 12);
    }

    @Override
    public FAL clone() {
        return new FAL();
    }
}
