package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Warhammer extends AbstractWeapon {

    public Warhammer() {
        super("Warhammer", "A powerful, metallic warhammer. Improves attack by 250.");
    }

    @Override
    public Integer modifyAtk() {
        return 250;
    }

    @Override
    public Warhammer clone() {
        return new Warhammer();
    }
}
