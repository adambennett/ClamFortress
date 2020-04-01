package com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.junit.jupiter.api.*;

public class PlagueTests {

    @Test
    public void runEncounter() {
        Game game = new Game();
        game = new Game();
        game.setId(1L);
        Database.setGameForTests(game);
        Village village = game.getVillage();
        Bubonic bubonic = new Bubonic(10);
        Contagion contagion = new Contagion(10);
        COVID19 covid19 = new COVID19(10);
        H1N1 h1N1 = new H1N1(10);
        Pandemic pandemic = new Pandemic(10);
        SARS sars = new SARS(10);
        SpanishFlu flu = new SpanishFlu(10);
        bubonic.runEncounter();
        contagion.runEncounter();
        covid19.runEncounter();
        h1N1.runEncounter();
        pandemic.runEncounter();
        sars.runEncounter();
        flu.runEncounter();
        Integer expectedSize = 7;
        /*Integer actualSize = village.getOngoingPlagues().size();
        Assertions.assertTrue(village.getOngoingPlagues().contains(bubonic));
        Assertions.assertTrue(village.getOngoingPlagues().contains(contagion));
        Assertions.assertTrue(village.getOngoingPlagues().contains(covid19));
        Assertions.assertTrue(village.getOngoingPlagues().contains(h1N1));
        Assertions.assertTrue(village.getOngoingPlagues().contains(pandemic));
        Assertions.assertTrue(village.getOngoingPlagues().contains(sars));
        Assertions.assertTrue(village.getOngoingPlagues().contains(flu));*/
    }
}