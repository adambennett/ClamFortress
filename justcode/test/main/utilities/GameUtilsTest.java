package main.utilities;

import main.models.*;
import main.models.resources.refined.*;
import main.utilities.consoleIO.*;
import org.junit.*;

import static org.junit.Assert.*;

public class GameUtilsTest {

    @Before
    public void setUp() {
        Game.startGame();
    }

    @Test
    public void devConsoleObtainObject() {
        GameUtils.devConsoleObtainObject(new Coin(), 10, new MidTurnMenu(), true);
        Integer expected = 10;
        Integer actual = Game.getVillage().getCoins();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenObtainingAnyItem() {
    }

    @Test
    public void getNewRaidCity() {
    }

    @Test
    public void obtainGameObject() {
    }

    @Test
    public void testObtainGameObject() {
    }

    @Test
    public void obtainArtifact() {
    }

    @Test
    public void obtainItem() {
    }

    @Test
    public void obtainBuilding() {
    }

    @Test
    public void discoverNode() {
    }
}