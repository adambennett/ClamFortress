package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class GameUtilsTest {

    @Test
    public void devConsoleObtainObject() {
        Game game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        GameUtils.devConsoleObtainObject(new Coin(), 10, new MidTurnMenu(), true);
        Integer expected = 10;
        Integer actual = game.getVillage().getCoins();
        Assertions.assertEquals(expected, actual);
    }

}