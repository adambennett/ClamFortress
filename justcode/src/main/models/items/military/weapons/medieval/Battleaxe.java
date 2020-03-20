package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

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
