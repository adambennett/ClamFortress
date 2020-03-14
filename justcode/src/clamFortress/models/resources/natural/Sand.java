package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Glass;


public class Sand extends NaturalResource implements Refinable, Harvestable {


    public Sand(){
        this.refined = new Glass();
    }

    @Override
    public Glass getRefined() {
        return (Glass) this.refined;
    }
}
