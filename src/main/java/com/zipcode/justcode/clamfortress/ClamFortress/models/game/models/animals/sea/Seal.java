package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;

public class Seal extends AbstractSeaAnimal {

    public Seal(){
        super("Seal", "Pinnipeds, commonly known as seals, are a widely distributed and diverse clade of carnivorous, fin-footed, semiaquatic marine mammals.",120);
    }

    @Override
    public Seal clone() {
        return new Seal();
    }
}
