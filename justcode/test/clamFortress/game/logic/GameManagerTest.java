package clamFortress.game.logic;

import org.junit.*;

import java.math.*;
import java.util.*;

import static org.junit.Assert.*;

public class GameManagerTest {

    private static GameManager game;

    @Before
    public void setup() {
        game = GameManager.getInstance();
    }

    @Test
    public void instanceVariablesTest() {

        game.incTurns();
        game.incCoins();
        game.incMana();
        game.incDate();
        game.incPop();
        game.incPopCap(500);
        game.incPop();
        game.incFaith();
        game.incStone();
        game.incWood();
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
        Assert.assertEquals(expectedCoins, game.getCoins());
        Assert.assertEquals(expectedTurn, game.getTurnNumber());
        Assert.assertEquals(expectedMana, game.getMana());
        Assert.assertEquals(expectedPop, game.getPopulation());
        Assert.assertEquals(expectedPopCap, game.getPopCap());
        Assert.assertEquals(expectedFaith, game.getFaith());
        Assert.assertEquals(expectedStone, game.getStone());
        Assert.assertEquals(expectedWood, game.getWood());
        Assert.assertEquals(expectedDate.toString(), game.getDate().toString());
    }

    @Test
    public void getInstanceTest() {
        Assert.assertNotNull(game);
    }
}