package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.*;

public class Harvesting extends AbstractGameAction {
   /* LinkedList<Seeds> cropRow;
    LinkedList<Seeds> cropsToRemove = new LinkedList<>();
    Integer foodToIncBy = 0;*/
    public Harvesting(int amountToRun) {
        super(amountToRun);
      /* this.cropRow = Game.getVillage().getFarmland().getNotReadyToHarvestSeeds();*/
    }

    @Override
    public void update() {
        /*if((hasCrops()) && (cropsReadyToHarvest())){
            for (Seeds seed: cropRow) {
               foodToIncBy +=10;
                cropsToRemove.add(seed);
            }
            Game.getVillage().incFood(foodToIncBy);
            Game.getVillage().getFarmland().getNotReadyToHarvestSeeds().removeAll(cropsToRemove);
            OutputManager.addToBot("You harvested " + foodToIncBy +" this month! I hope you had enough room to hold it all!");
        }
*/
        this.isDone = true;

    }

    @Override
    public Harvesting clone() {
        return new Harvesting(this.amountToRun);
    }
/*
    public Boolean cropsReadyToHarvest(){
       return Game.getVillage().getFarmland().getReadyToHarvest();
    }

    public Boolean hasCrops(){
        return Game.getVillage().getFarmland().getHasCrops();
    }*/
}
