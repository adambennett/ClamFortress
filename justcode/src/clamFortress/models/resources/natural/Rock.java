package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Stone;

public class Rock extends NaturalResource implements Refinable, Mineable {

    Stone stone =  new Stone();

    public Rock(){
        this.refined = stone;
    }

    @Override
    public Stone getRefined() {
        return (Stone) this.refined;
    }
}
