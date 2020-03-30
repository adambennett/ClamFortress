package com.zipcode.justcode.clamfortress.ClamFortress.models.game.managers;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import org.junit.jupiter.api.*;

import java.math.*;
import java.util.*;

public class GameManagerTest {

    @Test
    public void instanceVariablesTest() {
        Game gm = new Game();
        GameManager game = gm.gameManager;
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

        Assertions.assertEquals(expectedTurn, game.getTurnNumber());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getInstanceTest() {
        Game gm = new Game();
        GameManager game = gm.gameManager;
        Assertions.assertNotNull(game);
    }
}