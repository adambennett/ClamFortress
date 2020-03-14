package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Brick;

public class Clay extends NaturalResource implements Refinable, Mineable {

    Brick bricks = new Brick();

    public Clay(){
        this.refined = bricks;
    }
}
