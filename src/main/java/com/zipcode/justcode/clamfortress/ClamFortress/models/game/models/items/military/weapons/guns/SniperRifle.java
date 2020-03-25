package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.guns;


public class SniperRifle extends AbstractGun {

    public SniperRifle() {
        super("Sniper Rifle", "High precision scope. Shoot to kill.", 6, 900, 100);
    }

    @Override
    public SniperRifle clone() {
        return new SniperRifle();
    }
}
