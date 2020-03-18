package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.Jewelery;

public class Gems extends NaturalResource {


    public Gems(){
        super("Gems");
        this.refined = new Jewelery();
    }

    @Override
    public Jewelery getRefined() {
        return (Jewelery) this.refined;
    }

    @Override
    public Gems clone() {
        return new Gems();
    }
}

