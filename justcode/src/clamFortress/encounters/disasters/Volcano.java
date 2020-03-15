package clamFortress.encounters.disasters;

import clamFortress.models.*;

public class Volcano extends AbstractDisaster {
    @Override
    public void runEncounter(Village village, Board board) {
        village.addDisaster(this);
    }
}
