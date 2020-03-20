package main.models.resources.refined;

import main.models.resources.*;

public class Coin extends RefinedResource {
    public Coin() {
        super("Coins", "The basic currency object of Clam Fortress.");
    }

    @Override
    public Coin clone() {
        return new Coin();
    }
}
