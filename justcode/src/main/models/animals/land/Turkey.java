package main.models.animals.land;

import main.models.animals.*;

public class Turkey extends Animal {

    public Turkey(){
        super(22);
    }

    @Override
    public Turkey clone() {
        return new Turkey();
    }
}
