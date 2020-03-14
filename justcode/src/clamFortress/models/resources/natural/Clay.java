package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Brick;


public class Clay extends NaturalResource implements Refinable, Mineable {


    public Clay(){
        this.refined = new Brick();
    }

    @Override
    public Brick getRefined() {
        return (Brick) this.refined;
    }
}
