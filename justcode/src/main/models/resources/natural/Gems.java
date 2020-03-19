package main.models.resources.natural;

import main.interfaces.Smeltable;
import main.models.resources.*;
import main.models.resources.refined.Jewelery;

public class Gems extends NaturalResource implements Smeltable {
//impliments smithable for the time but maybe it should be refined in another way?

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

