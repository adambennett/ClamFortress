package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Glass;


public class Sand extends NaturalResource implements ResourceCost, Smeltable {


    public Sand(){
        super("Sand");
        this.refined = new Glass();
    }

    @Override
    public Glass getRefined() {
        return (Glass) this.refined;
    }

    @Override
    public Sand clone() {
        return new Sand();
    }
}
