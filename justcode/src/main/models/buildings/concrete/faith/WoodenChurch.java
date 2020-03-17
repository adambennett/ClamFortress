package main.models.buildings.concrete.faith;

import main.models.buildings.abstracts.*;

public class WoodenChurch extends AbstractFaithBuilding {

    public WoodenChurch(int faithBonus, int popCapInc) {
        super("Wooden Church", faithBonus, popCapInc);
    }
}
