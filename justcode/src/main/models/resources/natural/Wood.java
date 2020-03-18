package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Lumber;


public class Wood extends NaturalResource implements ResourceCost {

    public Wood(){
        super("Wood");
        this.refined = new Lumber();
    }

    @Override
    public Lumber getRefined() {
        return (Lumber) this.refined;
    }
}

