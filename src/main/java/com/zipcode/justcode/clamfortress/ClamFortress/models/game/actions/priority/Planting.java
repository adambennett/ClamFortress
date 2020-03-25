package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.*;

public class Planting extends AbstractGameAction {

    //LinkedList<Seeds> seeds = new LinkedList<>();

    public Planting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
/*

        if(hasSeeds() && !hasCrops()) {
           populateSeeds();
            //Sets the plantDate in the Farm-used by harvest to know if its ready
            Game.getVillage().getFarmland().setPlantDate(GameManager.getInstance().getTurnNumber().intValue());
            //currently takes all of your seeds//
            Game.getVillage().getFarmland().setNotReadyToHarvestSeeds(seeds);
            Game.getVillage().getFarmland().setHarvestDate(Game.getVillage().getFarmland().getPlantDate() + 3);
            OutputManager.addToBot("You planted " + seeds.size() + " seeds this month! They will be ready to harvest on turn "+ (Game.getVillage().getFarmland().getPlantDate() + 3));
            Game.getVillage().getFarmland().setHasCrops(true);
        }else if(!hasCrops() && !hasSeeds()){
            OutputManager.addToBot("No seeds to plant! Try trading or foraging.");
        } else if (hasCrops()){
            OutputManager.addToBot("Crops were already been planted on turn " + Game.getVillage().getFarmland().getPlantDate());
        }
*/

        this.isDone = true;
    }

    @Override
    public Planting clone() {
        return new Planting(this.amountToRun);
    }


   /* public Boolean hasSeeds() {
        return Game.getVillage().getResource("seeds") > 0;
    }

    public Boolean hasCrops(){
        return Game.getVillage().getFarmland().getHasCrops();
    }

    public Integer populateSeeds(){
        ArrayList<AbstractResource> seed = new ArrayList<>();
        Integer counter = 0;
        for (AbstractResource element: Game.getVillage().getAllResources()) {
            if(element.getName().equals("Seeds")){
                seeds.add((Seeds) element.clone());
                seed.add(element);
                counter ++;
            }
        }
        Game.getVillage().removeResource("seeds",seed.size());
        return counter;
    }*/
}