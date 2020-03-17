package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.IronIngot;

public class Iron extends NaturalResource {


    public Iron(){
        this.refined = new IronIngot();
    }

    @Override
    public IronIngot getRefined() {
        return (IronIngot) this.refined;
    }
}
