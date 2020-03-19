package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.IronIngot;

public class Iron extends NaturalResource implements ResourceCost, Smeltable {


    public Iron(){
        super("Iron");
        this.refined = new IronIngot();
    }

    @Override
    public IronIngot getRefined() {
        return (IronIngot) this.refined;
    }

    @Override
    public Iron clone() {
        return new Iron();
    }
}
