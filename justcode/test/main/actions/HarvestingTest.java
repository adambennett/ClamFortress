package main.actions;

import main.actions.priority.Harvesting;
import main.actions.priority.Planting;
import main.models.Game;
import main.models.resources.natural.Seeds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HarvestingTest {

    @Before
    public void before(){
        Game.startGame();
    }

    @Test
    public void cropsReadyToHarvestTest(){

        Harvesting harvesting = new Harvesting(1);

        Game.getVillage().getFarmland().setHarvestDate(10);
        Game.getVillage().getFarmland().setPlantDate(10);

        Boolean expected = true;
        Boolean actual = harvesting.cropsReadyToHarvest();
        Assert.assertEquals(expected,actual);
    }



    @Test
    public void thereAreCropsToHarvest(){
        Seeds seeds = new Seeds();
        Harvesting harvesting = new Harvesting(1);
        Planting planting = new Planting(1);
        Game.getVillage().addResource(seeds,10);
        planting.update();
        Game.getVillage().getFarmland().setHarvestDate(Game.getVillage().getFarmland().getPlantDate()+3);

        Boolean actual = harvesting.cropsReadyToHarvest();
        Boolean expected = true;


        Assert.assertEquals(expected,actual);
    }

    @Test
    public void update(){


    }
}
