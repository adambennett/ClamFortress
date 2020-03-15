package clamFortress.encounters.plagues;

import clamFortress.models.*;

public class H1N1 extends AbstractPlague {
    @Override
    public void runEncounter(Village village, Board board) {
        village.addPlague(this);
    }
}
