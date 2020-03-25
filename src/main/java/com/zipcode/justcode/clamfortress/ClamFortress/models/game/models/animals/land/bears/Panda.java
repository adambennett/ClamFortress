package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land.bears;

public class Panda extends AbstractBear {

    public Panda() {
        super("Panda", "The giant panda, also known as the panda bear or simply the panda, is a bear native to south central China. It is characterised by large, black patches around its eyes, over the ears, and across its round body. The name \"giant panda\" is sometimes used to distinguish it from the red panda, a neighboring musteloid.", 250);
    }

    @Override
    public Panda clone() {
        return new Panda();
    }
}
