package main.models.animals.land;

import main.models.animals.*;

public class Chicken extends AbstractLandAnimal {

    public Chicken() {
        super("Chicken", "The chicken is a type of domesticated fowl, a subspecies of the red junglefowl. They are one of the most common and widespread domestic animals, with a total population of 23.7 billion as of 2018, up from more than 19 billion in 2011. There are more chickens in the world than any other bird or domesticated fowl.", 18);
    }

    @Override
    public Chicken clone() {
        return new Chicken();
    }
}
