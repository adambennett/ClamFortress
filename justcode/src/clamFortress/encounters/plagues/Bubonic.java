package clamFortress.encounters.plagues;

import clamFortress.models.*;

public class Bubonic extends AbstractPlague {
    @Override
    public void runEncounter(Board board) {
        board.getVillage().addPlague(this);
    }
}
