package main.models.resources.natural;

import main.models.resources.*;
import main.models.resources.refined.Coin;

public class Gold extends NaturalResource {

    public Gold(){
        this.refined = new Coin();
    }
    @Override
    public Coin getRefined() {
        return (Coin) this.refined;
    }
}
