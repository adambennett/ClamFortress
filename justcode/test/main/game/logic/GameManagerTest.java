package main.game.logic;

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
        BigInteger expectedCoins = BigInteger.valueOf(1);
        BigInteger expectedMana = BigInteger.valueOf(1);
        BigInteger expectedPop = BigInteger.valueOf(1);
        BigInteger expectedPopCap = BigInteger.valueOf(500);
        BigInteger expectedFaith = BigInteger.valueOf(1);
        BigInteger expectedStone = BigInteger.valueOf(1);
        BigInteger expectedWood = BigInteger.valueOf(1);
        Date expectedDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(expectedDate);
        c.add(Calendar.DATE, 1);
        expectedDate = c.getTime();

        Assert.assertEquals(expectedTurn, game.getTurnNumber());
        Assert.assertEquals(expectedDate.toString(), game.getDate().toString());
    }

    @Test
    public void getInstanceTest() {
        Assert.assertNotNull(game);
    }
}