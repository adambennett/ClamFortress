package main.models.resources.natural;

import main.interfaces.Smeltable;
import main.models.resources.*;
import main.models.resources.refined.Jewelery;

public class Gems extends NaturalResource implements Smeltable {
//implements smithable for the time but maybe it should be refined in another way?
    // I think we should just use them to sell for coins at merchants
    // Basically secondary currency other than coins (more high level)
    // Could be even higher versions like diamonds, etc that extend this internally,
    // but externally it would be viewed as even higher tier
        // ie
        // coins (base currency)
        //  rubies -> coins
        //  sapphire -> ruby
        //  emerald -> sapphire
        //  topaz -> emerald
        //  diamond -> topaz
        //  obsidian -> diamond
        //  spacegoo -> obsidian

    public Gems(){
        super("Gems", "Worth a lot of gold! Or you could craft some Jewelery?");
        this.refined = new Jewelery();
    }

    @Override
    public Jewelery getRefined() {
        return (Jewelery) this.refined;
    }

    @Override
    public Gems clone() {
        return new Gems();
    }
}

