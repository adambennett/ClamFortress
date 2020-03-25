package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;

public class Cow extends AbstractLandAnimal {

    public Cow() {
        super("Cow", "Cattle, or cows, are the most common type of large domesticated ungulates. They are a prominent modern member of the subfamily Bovinae, are the most widespread species of the genus Bos, and are most commonly classified collectively as Bos taurus.",200);
    }

    @Override
    public Cow clone() {
        return new Cow();
    }
}
