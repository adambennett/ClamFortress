package main.models.animals.land;

import main.models.animals.*;

public class Turkey extends AbstractLandAnimal {

    public Turkey(){
        super(22);
    }

    @Override
    public Turkey clone() {
        return new Turkey();
    }
}
