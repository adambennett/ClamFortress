package main.actions;

import main.actions.priority.Fishing;
import main.models.Game;
import main.models.animals.sea.Penguin;
import main.models.artifacts.PodsRod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FishingTest {

    Fishing fishing;
    @Before
    public void setup() {
        fishing = new Fishing();
    }

    @Test
    public void fishingTestWithoutRod(){
        Game.startGame();

        Game.getGameBoard().addFish( new Penguin(),11);

        Game.getVillage().setFood(0);



        fishing.update();

        Integer actual = Game.getVillage().getFood();
        Integer expected = 24;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void fishingTestWithRod(){

        PodsRod rod = new PodsRod();
        Game.startGame();
        Game.getVillage().addArtifact(rod);
        Game.getGameBoard().addFish( new Penguin(),11);

        Game.getVillage().setFood(0);



        fishing.update();

        Integer actual = Game.getVillage().getFood();
        Integer expected = 48;

        Assert.assertEquals(expected,actual);
    }
}
