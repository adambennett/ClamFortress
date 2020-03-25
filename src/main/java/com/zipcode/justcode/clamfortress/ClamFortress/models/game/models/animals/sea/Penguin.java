package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;



public class Penguin extends AbstractSeaAnimal {

    public Penguin(){
        super("Penguin", "Penguins are a group of aquatic flightless birds. They live almost exclusively in the Southern Hemisphere, with only one species, the Galápagos penguin, found north of the equator. Highly adapted for life in the water, penguins have countershaded dark and white plumage and flippers for swimming.", 24);
    }

    @Override
    public Penguin clone() {
        return new Penguin();
    }
}
