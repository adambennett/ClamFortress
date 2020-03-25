package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.jungle;

public class Wildabeast extends AbstractJungleAnimal {

    public Wildabeast() {
        super("Wildabeast","Best not to mess with them.", 260);
    }

    @Override
    public Wildabeast clone() {
        return new Wildabeast();
    }


}
