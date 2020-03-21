package main.actions.priority;


import main.actions.AbstractGameAction;
import main.models.Game;
import main.models.managers.GameManager;
import main.models.managers.OutputManager;
import main.models.resources.AbstractResource;
import main.models.resources.natural.Seeds;
import java.util.ArrayList;
import java.util.LinkedList;

public class Planting extends AbstractGameAction {
LinkedList<Seeds> seeds = new LinkedList<>();
    public Planting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {

        if(hasSeeds() && !hasCrops()) {
           populateSeeds();
            //Sets the plantDate in the Farm-used by harvest to know if its ready
            Game.getVillage().getFarmland().setPlantDate(GameManager.getInstance().getTurnNumber().intValue());
            //currently takes all of your seeds//
            Game.getVillage().getFarmland().setNotReadyToHarvestSeeds(seeds);
            OutputManager.addToBot("You planted " + seeds.size() + " this month! They will be ready to harvest in 3 months");
        }else if(!hasCrops() && !hasSeeds()){
            OutputManager.addToBot("No seeds to plant! Try trading or foraging.");
        } else if (hasCrops()){
            OutputManager.addToBot("Crops were already been planted on turn " + Game.getVillage().getFarmland().getPlantDate());
        }

        this.isDone = true;
    }

    @Override
    public Planting clone() {
        return new Planting(this.amountToRun);
    }


    public Boolean hasSeeds() {
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
    }
}