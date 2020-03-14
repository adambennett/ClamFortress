package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Lumber;

public class Wood extends NaturalResource implements Refinable, Harvestable {

    Lumber lumber = new Lumber();

    public Wood(){
        this.refined = lumber;
    }
}

