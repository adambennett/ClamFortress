package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;

public class Cat extends AbstractLandAnimal {

    public Cat() {
        super("Cat", "Cat. The cat is a small carnivorous mammal. It is the only domesticated species in the family Felidae and often referred to as the domestic cat to distinguish it from wild members of the family. The cat is either a house cat, a farm cat or a feral cat; the latter ranges freely and avoids human contact. Cat.",22);
    }

    @Override
    public Cat clone() {
        return new Cat();
    }
}
