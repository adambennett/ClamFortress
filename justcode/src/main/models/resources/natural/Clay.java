package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Brick;


public class Clay extends NaturalResource implements ResourceCost {


    public Clay(){
        super("Clay");
        this.refined = new Brick();
    }

    @Override
    public Brick getRefined() {
        return (Brick) this.refined;
    }
}
