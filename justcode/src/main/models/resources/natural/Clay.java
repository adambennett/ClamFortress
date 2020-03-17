package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.Brick;


public class Clay extends NaturalResource {


    public Clay(){
        this.refined = new Brick();
    }

    @Override
    public Brick getRefined() {
        return (Brick) this.refined;
    }
}
