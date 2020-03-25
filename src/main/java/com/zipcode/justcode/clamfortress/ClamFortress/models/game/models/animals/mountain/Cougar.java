package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.mountain;

public class Cougar extends AbstractMountainAnimal {

    public Cougar(){
        super("Cougar", "The cougar is a large felid of the subfamily Felinae. It is native to the Americas. Its range spans from the Canadian Yukon to the southern Andes in South America, and is the widest of any large wild terrestrial mammal in the Western Hemisphere.", 145);
    }

    @Override
    public Cougar clone() {
        return new Cougar();
    }
}
