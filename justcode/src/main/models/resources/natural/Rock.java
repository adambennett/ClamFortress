package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Stone;

public class Rock extends NaturalResource implements ResourceCost, Smeltable {

    public Rock(){
        super("Rock");
        this.refined = new Stone();
    }

    @Override
    public Stone getRefined() {
        return (Stone) this.refined;
    }

    @Override
    public Rock clone() {
        return new Rock();
    }
}
