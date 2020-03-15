package clamFortress.encounters.miracles;

import clamFortress.models.*;

public class Wisdom extends AbstractMiracle {
    @Override
    public void runEncounter(Village village, Board board) {
        village.addMiracle(this);
    }
}
