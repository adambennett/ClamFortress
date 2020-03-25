package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

public class WoodSpikeWall extends AbstractDefenses {

    public WoodSpikeWall() {
        super("Wood Spike Wall", 75, 3, new Wood());
    }

    @Override
    public WoodSpikeWall clone() {
        return new WoodSpikeWall();
    }
}
