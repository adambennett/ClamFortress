package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Lumber;


public class Wood extends NaturalResource implements Refinable, Harvestable {

    public Wood(){
        this.refined = new Lumber();
    }

    @Override
    public Lumber getRefined() {
        return (Lumber) this.refined;
    }
}

