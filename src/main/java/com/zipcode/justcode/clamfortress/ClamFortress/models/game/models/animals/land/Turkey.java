package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.land;

public class Turkey extends AbstractLandAnimal {

    public Turkey(){
        super("Turkey", "The wild turkey is an upland ground bird native to North America, one of two extant species of turkey, and the heaviest member of the diverse Galliformes. It is the same species as the domestic turkey, which was originally derived from a southern Mexican subspecies of wild turkey.", 22);
    }

    @Override
    public Turkey clone() {
        return new Turkey();
    }
}
