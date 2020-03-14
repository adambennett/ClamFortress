package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.NaturalResource;
import clamFortress.models.resources.refined.Jewelry;

public class Gems extends NaturalResource implements Mineable {


    public Gems(){
        this.refined = new Jewelry();
    }

    @Override
    public Jewelry getRefined() {
        return (Jewelry) this.refined;
    }
}

