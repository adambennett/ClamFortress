package main.models.animals.land;

import main.models.animals.*;

public class Turkey extends Animal {
    @Override
    public Turkey clone() {
        return new Turkey();
    }
}
