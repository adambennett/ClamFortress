package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.foodbuilding;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.*;

public class Farmland extends AbstractFoodBuilding {
//Date that the seeds were planted
    private Integer plantDate;
    private Boolean hasCrops;
    private Integer harvestDate;
    private Boolean readyToHarvest;
//List added to when you use farm for the first time
    private LinkedList<Seeds> notReadyToHarvestSeeds = new LinkedList<>();
//*So really we dont need both of these right now but im going to leave it for the time being
// reason being we might make the seeds be actual objects for the different seed types
// and they could have different growing speeds*//
//Added to this list after some amount of in game time (maybe 3 turns?)
    private LinkedList<Seeds> readyToHarvestSeeds = new LinkedList<>();

    public Farmland() {
        super("Farmland", "A good place to Plant Seeds", 100, new Wood());
        this.plantDate=0;
        this.hasCrops = false;
        //set this way so the harvest date and and plantdate arent the same on initialization it was making weird tests pass.
        this.harvestDate=-1;
        this.readyToHarvest=false;
    }

    @Override
    public AbstractFoodBuilding clone() {
        return new Farmland();
    }

    @Override
    public void endPhase() {
        harvestDate++;
        if(GameManager.getInstance().getTurnNumber().intValue() == plantDate +3){
            readyToHarvest=true;
        }
    }

    public LinkedList<Seeds> getNotReadyToHarvestSeeds() {
        return notReadyToHarvestSeeds;
    }

    public void setNotReadyToHarvestSeeds(LinkedList<Seeds> notReadyToHarvestSeeds) {
        this.notReadyToHarvestSeeds = notReadyToHarvestSeeds;
    }

    public LinkedList<Seeds> getReadyToHarvestSeeds() {
        return readyToHarvestSeeds;
    }

    public void setReadyToHarvestSeeds(LinkedList<Seeds> readyToHarvestSeeds) {
        this.readyToHarvestSeeds = readyToHarvestSeeds;
    }

    public Integer getPlantDate() {
        return plantDate;
    }

    public void setPlantDate(Integer plantDate) {
        this.plantDate = plantDate;
    }

    public Boolean getHasCrops() {
        return hasCrops;
    }

    public void setHasCrops(Boolean hasCrops) {
        this.hasCrops = hasCrops;
    }

    public Integer getHarvestDate() {
        return harvestDate;
    }

    public void setHarvestDate(Integer harvestDate) {
        this.harvestDate = harvestDate;
    }

    public Boolean getReadyToHarvest(){
        return this.readyToHarvest;
    }
}
