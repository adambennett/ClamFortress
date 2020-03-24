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
        ClericBlessing blessing = new ClericBlessing(10);
        DivineHealing divineHealing = new DivineHealing(10);
        blessing.runEncounter();
        divineHealing.runEncounter();
        Integer expectedSize = 4;
        Integer actualSize = village.getActiveMiracles().size();
        Assert.assertTrue(village.getActiveMiracles().contains(blessing));
        Assert.assertTrue(village.getActiveMiracles().contains(divineHealing));
        Assert.assertEquals(expectedSize, actualSize);
    }
}