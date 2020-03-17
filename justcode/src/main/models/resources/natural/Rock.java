package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.Stone;

public class Rock extends NaturalResource {

    public Rock(){
        this.refined = new Stone();
    }

    @Override
    public Stone getRefined() {
        return (Stone) this.refined;
    }
}
