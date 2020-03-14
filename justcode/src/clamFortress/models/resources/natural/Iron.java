package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.IronIngot;

public class Iron extends NaturalResource implements Refinable, Mineable {


    public Iron(){
        this.refined = new IronIngot();
    }

    @Override
    public IronIngot getRefined() {
        return (IronIngot) this.refined;
    }
}
