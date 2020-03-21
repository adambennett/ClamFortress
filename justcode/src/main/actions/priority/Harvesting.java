package main.actions.priority;

import main.actions.AbstractGameAction;
import main.models.Game;
import main.models.managers.OutputManager;
import main.models.resources.natural.Seeds;

import java.util.LinkedList;

public class Harvesting extends AbstractGameAction {
    LinkedList<Seeds> cropRow;
    LinkedList<Seeds> cropsToRemove = new LinkedList<>();
    Integer foodToIncBy = 0;
    public Harvesting(int amountToRun) {
        super(amountToRun);
       this.cropRow = Game.getVillage().getFarmland().getNotReadyToHarvestSeeds();
    }

    @Override
    public void update() {
        if((hasCrops()) && (cropsReadyToHarvest())){
            for (Seeds seed: cropRow) {
               foodToIncBy +=10;
                cropsToRemove.add(seed);
            }
            Game.getVillage().incFood(foodToIncBy);
            Game.getVillage().getFarmland().getNotReadyToHarvestSeeds().removeAll(cropsToRemove);
            OutputManager.addToBot("You harvested " + foodToIncBy +" this month! I hope you had enough room to hold it all!");
        }

        this.isDone = true;

    }

    @Override
    public Harvesting clone() {
        return new Harvesting(this.amountToRun);
    }

    public Boolean cropsReadyToHarvest(){
       return Game.getVillage().getFarmland().getReadyToHarvest();
    }

    public Boolean hasCrops(){
        return Game.getVillage().getFarmland().getHasCrops();
    }
}
