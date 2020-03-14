package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Glass;

public class Sand extends NaturalResource implements Refinable, Harvestable {

    Glass glass= new Glass();

    public Sand(){
        this.refined = glass;
    }
}
