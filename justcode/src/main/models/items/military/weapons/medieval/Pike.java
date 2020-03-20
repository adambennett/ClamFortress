package main.models.items.military.weapons.medieval;

import main.models.items.military.weapons.*;

public class Pike extends AbstractWeapon {

    public Pike() {
        super("Pike", "A long, slender steel pike. Improves attack by 65.");
    }

    @Override
    public Integer modifyAtk() {
        return 65;
    }

    @Override
    public Pike clone() {
        return new Pike();
    }
}
