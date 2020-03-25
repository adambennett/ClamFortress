package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class Telescope extends AbstractArtifact implements Unique {



    public Telescope() {
        super("Telescope", "Improves the chance to discover new regions while Scouting.");
    }


    @Override
    public Telescope clone() {
        return new Telescope();
    }
}
