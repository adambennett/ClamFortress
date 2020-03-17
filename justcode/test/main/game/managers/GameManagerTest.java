package main.game.managers;

import main.models.managers.*;
import org.junit.*;

import java.math.*;
import java.util.*;

public class GameManagerTest {

    private static GameManager game;

    @Before
    public void setup() {
        game = GameManager.getInstance();
    }

    @Test
    public void instanceVariablesTest() {
        game.incTurns();
        game.incDate();
        BigInteger expectedTurn = BigInteger.valueOf(2);
        Date expectedDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(expectedDate);
        c.add(Calendar.DATE, 1);
        expectedDate = c.getTime();

        String[] spliceA = expectedDate.toString().split(" ");
        String[] spliceB = game.getDate().toString().split(" ");
        String expected = spliceA[0] + spliceA[1] + spliceA[2];
        String actual = spliceB[0] + spliceB[1] + spliceB[2];

        Assert.assertEquals(expectedTurn, game.getTurnNumber());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getInstanceTest() {
        Assert.assertNotNull(game);
    }
}