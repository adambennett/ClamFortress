package clamFortress.encounters.miracles;

import clamFortress.models.*;

public class Wisdom extends AbstractMiracle {
    @Override
    public void runEncounter(Board board) {
        board.getVillage().addMiracle(this);
    }
}
