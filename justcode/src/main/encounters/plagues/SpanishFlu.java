package main.encounters.plagues;

import main.models.*;

public class SpanishFlu extends AbstractPlague {
    @Override
    public void runEncounter() {
        Game.getVillage().addPlague(this);
    }
}
