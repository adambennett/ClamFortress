package main.actions.priority;

import main.actions.AbstractGameAction;
import main.models.Game;

public class Harvesting extends AbstractGameAction {

    public Harvesting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if(thereAreCropsToHarvest()){

        }

        this.isDone = true;

    }

    @Override
    public Harvesting clone() {
        return new Harvesting(this.amountToRun);
    }


    public Boolean thereAreCropsToHarvest(){
        return Game.getVillage().getFarmland().getHasCrops();
    }
}
