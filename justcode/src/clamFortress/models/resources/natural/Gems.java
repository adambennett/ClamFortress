package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.NaturalResource;
import clamFortress.models.resources.refined.Jewelry;

public class Gems extends NaturalResource implements Mineable {

    Jewelry jewelry = new Jewelry();

    public Gems(){
        this.refined = jewelry;
    }
}
