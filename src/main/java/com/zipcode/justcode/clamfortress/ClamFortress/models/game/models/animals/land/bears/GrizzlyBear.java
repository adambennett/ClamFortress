package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears;

public class GrizzlyBear extends AbstractBear {

    public GrizzlyBear() {
        super("Grizzly Bear", "The grizzly bear, also known as the North American brown bear or simply grizzly, is a large population or subspecies of the brown bear inhabiting North America.", 250);
    }

    @Override
    public GrizzlyBear clone() {
        return new GrizzlyBear();
    }
}
