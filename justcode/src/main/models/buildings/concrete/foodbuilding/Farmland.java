package main.models.buildings.concrete.foodbuilding;

import main.models.buildings.abstracts.AbstractFoodBuilding;
import main.models.resources.natural.Seeds;
import main.models.resources.natural.Wood;

import java.util.LinkedList;

public class Farmland extends AbstractFoodBuilding {
//Date that the seeds were planted
    private Integer plantDate;
    private Boolean hasCrops;
    private Integer harvestDate;
//List added to when you use farm for the first time
    private LinkedList<Seeds> notReadyToHarvestSeeds = new LinkedList<>();

//Added to this list after some amount of in game time (maybe 3 turns?)
    private LinkedList<Seeds> readyToHarvestSeeds = new LinkedList<>();

    public Farmland() {
        super("Farmland", "A good place to Plant Seeds", 100, new Wood());
        this.plantDate=0;
        this.hasCrops = false;
        this.harvestDate=0;
    }

    @Override
    public AbstractFoodBuilding clone() {
        return new Farmland();
    }

    @Override
    public void endPhase() {harvestDate++;}

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
}
