package main.actions.priority;

import main.actions.*;
import main.models.tech.*;
import main.models.tech.eras.BronzeAge;

public class Mining extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Mining clone() {
        return new Mining();
    }


}
