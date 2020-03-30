package com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.housing.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class CursedTest {

    @Test
    public void runCurse() {
        Game game = new Game();
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        Cursed cursed = new CursedHome();
        Integer firstNether = game.getGameManager().getNethermod();
        cursed.runCurse();
        Integer expected = 0;
        Integer actual = game.getGameManager().getNethermod();
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(expected, firstNether);
    }
}