package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import org.junit.jupiter.api.*;

public class HarvestingTest {

    @Test
    public void cropsReadyToHarvestTest(){
        Game.startGame();
        Harvesting harvesting = new Harvesting(1);
        Game.getVillage().getFarmland().setHarvestDate(10);
        Game.getVillage().getFarmland().setPlantDate(10);
        Boolean actual = harvesting.cropsReadyToHarvest();
        Assertions.assertTrue(!actual);
    }



    @Test
    public void thereAreCropsToHarvest(){
        Game.startGame();
        Seeds seeds = new Seeds();
        Harvesting harvesting = new Harvesting(1);
        Planting planting = new Planting(1);
        Game.getVillage().addResource(seeds,10);
        planting.update();
        Game.getVillage().getFarmland().setHarvestDate(Game.getVillage().getFarmland().getPlantDate()+3);
        Boolean actual = harvesting.cropsReadyToHarvest();
        Assertions.assertTrue(!actual);
    }

}
