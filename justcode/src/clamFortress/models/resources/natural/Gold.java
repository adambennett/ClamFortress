package clamFortress.models.resources.natural;

import clamFortress.interfaces.*;
import clamFortress.models.resources.*;
import clamFortress.models.resources.refined.Coin;

public class Gold extends NaturalResource implements Refinable, Mineable {

    public Gold(){
        this.refined = new Coin();
    }
    @Override
    public Coin getRefined() {
        return (Coin) this.refined;
    }
}
