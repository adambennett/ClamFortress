package main.actions;

import main.actions.priority.*;
import main.models.Game;
import main.models.animals.land.bears.BlackBear;
import org.junit.*;

public class HuntingTest { ;

    private static Hunting hunting;

    @Before
    public void setup() {
        hunting = new Hunting();
    }
    @Test
    public void huntingTest(){
        Game.startGame();
        Game.getGameBoard().addAnimals(new BlackBear(), 10);
        hunting.update();
        Integer actual = Game.getVillage().getFood();
        Integer expected = 250;
        Assert.assertEquals(expected,actual);
    }
}
