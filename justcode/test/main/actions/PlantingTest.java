package main.actions;

import main.actions.priority.Planting;
import main.models.Game;
import main.models.resources.natural.Seeds;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlantingTest {

    @Before
    public void before(){
        Game.startGame();
    }


    @Test
    public void hasSeedTest(){
        Seeds seeds = new Seeds();
        Planting planting = new Planting(1);
        Game.getVillage().addResource(seeds,10);

        Boolean expected = true;
        Boolean actual = planting.hasSeeds();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void populateSeedsTest(){
        Seeds seeds = new Seeds();
        Planting planting = new Planting(1);
        Game.getVillage().addResource(seeds, 10);

       Integer actual =  planting.populateSeeds();
       Integer expected = 10;

       Assert.assertEquals(expected,actual);
    }

    @Test
    public void updateTest(){
        Seeds seeds = new Seeds();
        Planting planting = new Planting(1);
        Game.getVillage().addResource(seeds, 10);
        planting.update();

        Integer expectedSeeds = 0;//0
        Integer actualSeeds = planting.populateSeeds();

        Integer seedsNotReadyToPopulateexpected = 10;//10

        Integer seedsNotReadyToPopulateActual = Game.getVillage().getFarmland().getNotReadyToHarvestSeeds().size();

        Assert.assertEquals(seedsNotReadyToPopulateexpected,seedsNotReadyToPopulateActual);
        Assert.assertEquals(expectedSeeds,actualSeeds);
    }
}
