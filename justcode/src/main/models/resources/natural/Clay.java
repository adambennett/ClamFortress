package main.models.resources.natural;

import main.interfaces.ResourceCost;
import main.interfaces.Smeltable;
import main.models.resources.NaturalResource;
import main.models.resources.refined.Brick;


public class Clay extends NaturalResource implements ResourceCost, Smeltable {


    public Clay(){
        super("Clay");
        this.refined = new Brick();
    }

    @Override
    public Brick getRefined() {
        return (Brick) this.refined;
    }

    @Override
    public Clay clone() {
        return new Clay();
    }
}
