package clamFortress.encounters.plagues;

import clamFortress.models.*;

public class Bubonic extends AbstractPlague {
    @Override
    public void runEncounter(Village village, Board board) {
        village.addPlague(this);
    }
}
