package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;
import org.junit.jupiter.api.*;

public class GameUtilsTest {

    @BeforeEach
    public void setUp() {
        Game.startGame();
    }

    @Test
    public void devConsoleObtainObject() {
        GameUtils.devConsoleObtainObject(new Coin(), 10, new MidTurnMenu(), true);
        Integer expected = 10;
        Integer actual = Game.getVillage().getCoins();
        Assertions.assertEquals(expected, actual);
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