package main.encounters;

import main.encounters.plagues.*;
import main.models.managers.*;
import org.junit.*;

import java.util.*;

public class EncounterManagerTest {

    @Before
    public void setUp() {
        EncounterManager.setSeed(22);
    }

    @Test
    public void generateEncounters() {
        ArrayList<AbstractEncounter> actual = EncounterManager.generateEncounters();
        boolean found = false;
        Bubonic bub = new Bubonic();
        for (AbstractEncounter enc : actual) {
            if (enc.getClass().equals(bub.getClass())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @Test
    public void generateEncountersParam() {
        ArrayList<AbstractEncounter> actual = EncounterManager.generateEncounters(43);
        boolean found = false;
        Bubonic bub = new Bubonic();
        for (AbstractEncounter enc : actual) {
            if (enc.getClass().equals(bub.getClass())) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }
}