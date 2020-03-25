package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.medieval;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.military.weapons.*;

public class Battleaxe extends AbstractWeapon {

    public Battleaxe() {
        super("Battleaxe", "A standard metal battle axe. Improves attack by 15.");
    }

    @Override
    public Integer modifyAtk() {
        return 15;
    }

    @Override
    public Battleaxe clone() {
        return new Battleaxe();
    }
}
