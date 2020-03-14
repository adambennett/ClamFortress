package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.CopperIngot;

public class Copper extends NaturalResource implements Refinable, Mineable {

    CopperIngot ingot = new CopperIngot();

    public Copper(){
        this.refined = ingot;
    }
}
