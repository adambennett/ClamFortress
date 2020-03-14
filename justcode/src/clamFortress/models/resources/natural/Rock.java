package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Stone;

public class Rock extends NaturalResource implements Refinable, Mineable {

    public Rock(){
        this.refined = new Stone();
    }

    @Override
    public Stone getRefined() {
        return (Stone) this.refined;
    }
}
