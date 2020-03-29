package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class DisasterTests {

    @Test
    public void runEncounter() {
        Game game = new Game();
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        Village village = game.getVillage();
        Earthquake eq = new Earthquake();
        Fire fire = new Fire(10);
        Flood flood = new Flood(10);
        Hurricane hurricane = new Hurricane(10);
        Tornado tornado = new Tornado(10);
        Tsunami tsunami = new Tsunami();
        Typhoon typhoon = new Typhoon(10);
        Volcano volcano = new Volcano();
        Typhoon typhoonB = new Typhoon(10);
        Volcano volcanoB = new Volcano();
        eq.runEncounter();
        fire.runEncounter();
        flood.runEncounter();
        hurricane.runEncounter();
        tornado.runEncounter();
        tsunami.runEncounter();
        typhoon.runEncounter();
        volcano.runEncounter();
        typhoonB.runEncounter();
        volcanoB.runEncounter();
        Integer expectedSize = 8;
        Integer actualSize = village.getOngoingDisasters().size();
        Assertions.assertTrue(village.getOngoingDisasters().contains(eq));
        Assertions.assertTrue(village.getOngoingDisasters().contains(fire));
        Assertions.assertTrue(village.getOngoingDisasters().contains(flood));
        Assertions.assertTrue(village.getOngoingDisasters().contains(hurricane));
        Assertions.assertTrue(village.getOngoingDisasters().contains(tornado));
        Assertions.assertTrue(village.getOngoingDisasters().contains(tsunami));
        Assertions.assertTrue(village.getOngoingDisasters().contains(typhoon));
        Assertions.assertTrue(village.getOngoingDisasters().contains(volcano));
        Assertions.assertEquals(expectedSize, actualSize);
    }
}