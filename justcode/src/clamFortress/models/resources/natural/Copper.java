package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.CopperIngot;

public class Copper extends NaturalResource implements Refinable, Mineable {


    public Copper(){
        this.refined = new CopperIngot();
    }

    @Override
    public CopperIngot getRefined() {
        return (CopperIngot) this.refined;
    }
}
