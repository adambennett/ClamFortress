package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.CopperIngot;

public class Copper extends NaturalResource {


    public Copper(){
        this.refined = new CopperIngot();
    }

    @Override
    public CopperIngot getRefined() {
        return (CopperIngot) this.refined;
    }
}
