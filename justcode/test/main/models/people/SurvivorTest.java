package main.models.people;

import main.enums.Gender;
import main.enums.Race;
import main.models.beings.*;
import main.utilities.builders.SurvivorBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SurvivorTest {

    private static Survivor testSurvivor;
    private static Survivor defaultTestSurvivor;

    @Before
    public void setUp() {
        defaultTestSurvivor = new SurvivorBuilder().createSurvivor();
        testSurvivor = new SurvivorBuilder()
                .setAge(100)
                .setDexterity(101)
                .setAgility(102)
                .setEngineering(103)
                .setGender(Gender.MALE)
                .setHealthPoints(200)
                .setMaxHP(250)
                .setMagic(50)
                .setName("Adam")
                .setRace(Race.HUMAN)
                .setStrength(250)
                .setIntelligence(104)
                .createSurvivor();
    }
    
    @Test
    public void nullaryTest() {
        Integer expectedAge = 5;
        Integer expectedDex = 0;
        Integer expectedAgi = 0;
        Integer expectedEng = 0;
        Integer expectedHP  = 10;
        Integer expectedMag = 0;
        Integer expectedStr = 0;
        Integer expectedInt = 0;
        Gender  expectedGender = Gender.MALE;
        Race    expectedRace   = Race.HUMAN;
        String  expectedName   = "Villager";
        Assert.assertEquals(expectedAge, defaultTestSurvivor.getAge());
        Assert.assertEquals(expectedDex, defaultTestSurvivor.getDexterity());
        Assert.assertEquals(expectedAgi, defaultTestSurvivor.getAgility());
        Assert.assertEquals(expectedEng, defaultTestSurvivor.getEngineering());
        Assert.assertEquals(expectedHP, defaultTestSurvivor.getHP());
        Assert.assertEquals(expectedMag, defaultTestSurvivor.getMagic());
        Assert.assertEquals(expectedStr, defaultTestSurvivor.getStrength());
        Assert.assertEquals(expectedInt, defaultTestSurvivor.getIntelligence());
        Assert.assertEquals(expectedGender, defaultTestSurvivor.getGender());
        Assert.assertEquals(expectedRace, defaultTestSurvivor.getRace());
        Assert.assertEquals(expectedName, defaultTestSurvivor.getName());
    }

    @Test
    public void getterTest() {
        Integer expectedAge = 100;
        Integer expectedDex = 101;
        Integer expectedAgi = 102;
        Integer expectedEng = 103;
        Integer expectedHP  = 200;
        Integer expectedmaxHp = 250;
        Integer expectedMag = 50;
        Integer expectedStr = 250;
        Integer expectedInt = 104;
        Gender  expectedGender = Gender.MALE;
        Race    expectedRace   = Race.HUMAN;
        String  expectedName   = "Adam";
        Assert.assertEquals(expectedAge, testSurvivor.getAge());
        Assert.assertEquals(expectedDex, testSurvivor.getDexterity());
        Assert.assertEquals(expectedAgi, testSurvivor.getAgility());
        Assert.assertEquals(expectedEng, testSurvivor.getEngineering());
        Assert.assertEquals(expectedHP, testSurvivor.getHP());
        Assert.assertEquals(expectedmaxHp,testSurvivor.getMaxHp());
        Assert.assertEquals(expectedMag, testSurvivor.getMagic());
        Assert.assertEquals(expectedStr, testSurvivor.getStrength());
        Assert.assertEquals(expectedInt, testSurvivor.getIntelligence());
        Assert.assertEquals(expectedGender, testSurvivor.getGender());
        Assert.assertEquals(expectedRace, testSurvivor.getRace());
        Assert.assertEquals(expectedName, testSurvivor.getName());
    }

    @Test
    public void setterTest() {
        Integer expectedAge = 200;
        Integer expectedDex = 201;
        Integer expectedAgi = 202;
        Integer expectedEng = 203;
        Integer expectedHP  = 300;
        Integer expectedMag = 250;
        Integer expectedStr = 350;
        Integer expectedInt = 204;
        Gender  expectedGender = Gender.FEMALE;
        Race    expectedRace   = Race.ORC;
        String  expectedName   = "Jeremy";
        testSurvivor.setAge(200);
        testSurvivor.setDexterity(201);
        testSurvivor.setAgility(202);
        testSurvivor.setEngineering(203);
        testSurvivor.setHealthPoints(300);
        testSurvivor.setMagic(250);
        testSurvivor.setStrength(350);
        testSurvivor.setIntelligence(204);
        testSurvivor.setGender(Gender.FEMALE);
        testSurvivor.setRace(Race.ORC);
        testSurvivor.setName("Jeremy");
        Assert.assertEquals(expectedAge, testSurvivor.getAge());
        Assert.assertEquals(expectedDex, testSurvivor.getDexterity());
        Assert.assertEquals(expectedAgi, testSurvivor.getAgility());
        Assert.assertEquals(expectedEng, testSurvivor.getEngineering());
        Assert.assertEquals(expectedHP, testSurvivor.getHP());
        Assert.assertEquals(expectedMag, testSurvivor.getMagic());
        Assert.assertEquals(expectedStr, testSurvivor.getStrength());
        Assert.assertEquals(expectedInt, testSurvivor.getIntelligence());
        Assert.assertEquals(expectedGender, testSurvivor.getGender());
        Assert.assertEquals(expectedRace, testSurvivor.getRace());
        Assert.assertEquals(expectedName, testSurvivor.getName());
    }
}