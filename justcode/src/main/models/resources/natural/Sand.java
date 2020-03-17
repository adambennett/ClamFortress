package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.Glass;


public class Sand extends NaturalResource {


    public Sand(){
        this.refined = new Glass();
    }

    @Override
    public Glass getRefined() {
        return (Glass) this.refined;
    }
}
