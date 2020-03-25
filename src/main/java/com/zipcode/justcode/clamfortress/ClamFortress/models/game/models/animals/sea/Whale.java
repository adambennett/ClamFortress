package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;

public class Whale extends AbstractSeaAnimal {

    public Whale(){
        super("Whale", "Whales are a widely distributed and diverse group of fully aquatic placental marine mammals. They are an informal grouping within the infraorder Cetacea, usually excluding dolphins and porpoises. Whales, dolphins and porpoises belong to the order Cetartiodactyla, which consists of even-toed ungulates.",  450);
    }

    @Override
    public Whale clone() {
        return new Whale();
    }
}
