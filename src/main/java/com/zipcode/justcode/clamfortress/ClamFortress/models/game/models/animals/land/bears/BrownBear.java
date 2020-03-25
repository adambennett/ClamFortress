package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears;

public class BrownBear extends AbstractBear {

    public BrownBear() {
        super("Brown Bear", "The brown bear is a bear species that is found across much of northern Eurasia and North America. In North America, the populations of brown bears are often called \"grizzly bears\".", 250);
    }

    @Override
    public BrownBear clone() {
        return new BrownBear();
    }
}
