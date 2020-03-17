package main.encounters.miracles;

import main.models.*;
import main.models.nodes.*;
import org.junit.*;

public class MiraclesTests {

    private static Village village;

    @Before
    public void setUp() {
        Game.startGame();
        village = Game.getVillage();
    }


    @Test
    public void runEncounter() {
        Blessing blessing = new Blessing();
        DivineHealing divineHealing = new DivineHealing();
        DivineIntervention divineIntervention = new DivineIntervention();
        Wisdom wisdom = new Wisdom();
        DivineIntervention divineInterventionB = new DivineIntervention();
        Wisdom wisdomB = new Wisdom();
        blessing.runEncounter();
        divineHealing.runEncounter();
        divineIntervention.runEncounter();
        wisdom.runEncounter();
        divineInterventionB.runEncounter();
        wisdomB.runEncounter();
        Integer expectedSize = 4;
        Integer actualSize = village.getActiveMiracles().size();
        Assert.assertTrue(village.getActiveMiracles().contains(blessing));
        Assert.assertTrue(village.getActiveMiracles().contains(divineHealing));
        Assert.assertTrue(village.getActiveMiracles().contains(divineIntervention));
        Assert.assertTrue(village.getActiveMiracles().contains(wisdom));
        Assert.assertEquals(expectedSize, actualSize);
    }
}