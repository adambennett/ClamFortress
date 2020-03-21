package main.interfaces;

import main.models.*;
import main.models.buildings.concrete.housing.*;
import org.junit.*;

import static org.junit.Assert.*;

public class CursedTest {

    private static Cursed cursed;

    @Before
    public void setUp() {
        Game.startGame();
        cursed = new CursedHome();
    }

    @Test
    public void runCurse() {
        Integer firstNether = Game.getGameManager().getNethermod();
        cursed.runCurse();
        Integer expected = 0;
        Integer actual = Game.getGameManager().getNethermod();
        Assert.assertEquals(expected, actual);
        Assert.assertNotEquals(expected, firstNether);
    }
}