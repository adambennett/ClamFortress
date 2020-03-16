package clamFortress.encounters.disasters;

import clamFortress.models.*;

public class Earthquake extends AbstractDisaster {
    @Override
    public void runEncounter(Board board) {
        board.getVillage().addDisaster(this);
    }
}
