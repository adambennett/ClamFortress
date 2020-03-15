package clamFortress.encounters.miracles;

import clamFortress.models.*;

public class Blessing extends AbstractMiracle {
    @Override
    public void runEncounter(Village village, Board board) {
        village.addMiracle(this);
    }
}
