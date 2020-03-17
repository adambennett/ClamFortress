package main.encounters.plagues;

import main.models.*;
import main.models.nodes.*;
import org.junit.*;


public class PlagueTests {

    private static Village village;

    @Before
    public void setUp() {
        Game.startGame();
        village = Game.getVillage();
    }


    @Test
    public void runEncounter() {
        Bubonic bubonic = new Bubonic();
        Contagion contagion = new Contagion();
        COVID19 covid19 = new COVID19();
        H1N1 h1N1 = new H1N1();
        Pandemic pandemic = new Pandemic();
        SARS sars = new SARS();
        SpanishFlu flu = new SpanishFlu();
        SARS sarsB = new SARS();
        SpanishFlu fluB = new SpanishFlu();
        bubonic.runEncounter();
        contagion.runEncounter();
        covid19.runEncounter();
        h1N1.runEncounter();
        pandemic.runEncounter();
        sars.runEncounter();
        flu.runEncounter();
        sarsB.runEncounter();
        fluB.runEncounter();
        Integer expectedSize = 7;
        Integer actualSize = village.getOngoingPlagues().size();
        Assert.assertTrue(village.getOngoingPlagues().contains(bubonic));
        Assert.assertTrue(village.getOngoingPlagues().contains(contagion));
        Assert.assertTrue(village.getOngoingPlagues().contains(covid19));
        Assert.assertTrue(village.getOngoingPlagues().contains(h1N1));
        Assert.assertTrue(village.getOngoingPlagues().contains(pandemic));
        Assert.assertTrue(village.getOngoingPlagues().contains(sars));
        Assert.assertTrue(village.getOngoingPlagues().contains(flu));
        Assert.assertFalse(village.getOngoingPlagues().contains(sarsB));
        Assert.assertFalse(village.getOngoingPlagues().contains(fluB));
    }
}