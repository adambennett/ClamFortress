package main.actions;

import main.game.Game;
import main.models.animals.land.bears.BlackBear;
import org.junit.Assert;
import org.junit.Test;

public class HuntingTest { ;

    Hunting hunting = new Hunting();
    @Test
    public void huntingTest(){

        Game.getGameBoard().addAnimals(new BlackBear(), 10);
        hunting.update();
        Integer actual = Game.getVillage().getFood();
        Integer expected = 0;
        Assert.assertEquals(expected,actual);
    }
}
