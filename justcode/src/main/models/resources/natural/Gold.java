package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.Coin;

public class Gold extends NaturalResource implements ResourceCost, Smeltable {

    public Gold(){
        super("Gold", "Used to mint Coins.");
        this.refined = new Coin();
    }
    @Override
    public Coin getRefined() {
        return (Coin) this.refined;
    }

    @Override
    public Gold clone() {
        return new Gold();
    }
}
