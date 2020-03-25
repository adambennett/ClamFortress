package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Coin extends RefinedResource {
    public Coin() {
        super("Coins", "The basic currency object of Clam Fortress.");
    }

    @Override
    public Coin clone() {
        return new Coin();
    }
}
