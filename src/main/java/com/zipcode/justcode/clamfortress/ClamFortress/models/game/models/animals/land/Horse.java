package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;

public class Horse extends AbstractLandAnimal {

    public Horse() {
        super("Horse", "The horse is one of two extant subspecies of Equus ferus. It is an odd-toed ungulate mammal belonging to the taxonomic family Equidae. The horse has evolved over the past 45 to 55 million years from a small multi-toed creature, Eohippus, into the large, single-toed animal of today.", 210);
    }

    @Override
    public Horse clone() {
        return new Horse();
    }
}
