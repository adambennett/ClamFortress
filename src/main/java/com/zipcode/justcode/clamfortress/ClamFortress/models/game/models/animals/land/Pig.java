package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;

public class Pig extends AbstractLandAnimal {

    public Pig() {
        super("Pig", "A pig is any of the animals in the genus Sus, within the even-toed ungulate family Suidae. Pigs include domestic pigs and their ancestor, the common Eurasian wild boar, along with other species. Pigs, like all suids, are native to the Eurasian and African continents, ranging from Europe to Pacific islands.", 90);
    }

    @Override
    public Pig clone() {
        return new Pig();
    }
}
