package main.models.resources.refined;

import main.models.resources.*;

public class Coin extends RefinedResource {
    public Coin() {
        super("Coins");
    }

    @Override
    public Coin clone() {
        return new Coin();
    }
}
