package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.defending;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class ShortStoneWall extends AbstractDefenses {

    public ShortStoneWall() {
        super("Short Stone Wall", 150, 2, new Stone());
    }

    @Override
    public ShortStoneWall clone() {
        return new ShortStoneWall();
    }
}
