package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.IronIngot;

public class Iron extends NaturalResource implements Refinable, Mineable {

    IronIngot ingot = new IronIngot();

    public Iron(){
        this.refined = ingot;
    }
}
