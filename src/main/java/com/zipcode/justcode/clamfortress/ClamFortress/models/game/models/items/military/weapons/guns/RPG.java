package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class RPG extends AbstractGun {

    public RPG() {
        super("RPG", "BIG BOOMS!", 4, 6000, 30);
    }

    @Override
    public RPG clone() {
        return new RPG();
    }
}
