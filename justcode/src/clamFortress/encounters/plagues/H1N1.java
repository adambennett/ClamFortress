package clamFortress.encounters.plagues;

import clamFortress.models.*;

public class H1N1 extends AbstractPlague {
    @Override
    public void runEncounter(Board board) {
        board.getVillage().addPlague(this);
    }
}
