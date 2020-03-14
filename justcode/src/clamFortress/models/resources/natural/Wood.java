package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Lumber;

public class Wood extends NaturalResource implements Refinable, Harvestable {

    public Wood(){
        this.refined = new Lumber();
    }
}

