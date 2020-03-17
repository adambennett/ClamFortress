package main.models.resources.natural;

import main.models.resources.NaturalResource;
import main.models.resources.refined.Jewelry;

public class Gems extends NaturalResource {


    public Gems(){
        this.refined = new Jewelry();
    }

    @Override
    public Jewelry getRefined() {
        return (Jewelry) this.refined;
    }
}

