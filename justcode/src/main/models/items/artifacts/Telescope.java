package main.models.items.artifacts;

import main.interfaces.*;

public class Telescope extends AbstractArtifact implements Unique {



    public Telescope() {
        super("Telescope", "Improves the chance to discover new regions while Scouting.");
    }


    @Override
    public Telescope clone() {
        return new Telescope();
    }
}
