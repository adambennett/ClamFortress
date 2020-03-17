package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Coin;

public class Gold extends NaturalResource implements Refinable, Mineable {

    public Gold(){
        this.refined = new Coin();
    }
    @Override
    public Coin getRefined() {
        return (Coin) this.refined;
    }
}
