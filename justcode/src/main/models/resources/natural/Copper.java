package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.CopperIngot;

public class Copper extends NaturalResource implements ResourceCost, Smeltable {


    public Copper(){
        super("Copper");
        this.refined = new CopperIngot();
    }

    @Override
    public CopperIngot getRefined() {
        return (CopperIngot) this.refined;
    }

    @Override
    public Copper clone() {
        return new Copper();
    }
}
