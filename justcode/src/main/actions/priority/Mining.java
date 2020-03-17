package main.actions.priority;

import main.actions.*;
import main.models.tech.*;
import main.models.tech.eras.BronzeAge;

public class Mining extends AbstractGameAction {

    @Override
    public void update() {
        if(TechTree.getCurrentEra() instanceof BronzeAge){

        }
        this.isDone = true;
    }


}
