package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;
import org.junit.jupiter.api.*;

public class SurvivorTest {

    private static Survivor testSurvivor;
    private static Survivor defaultTestSurvivor;

    @BeforeEach
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
        Assertions.assertEquals(expectedAge, defaultTestSurvivor.getAge());
        Assertions.assertEquals(expectedDex, defaultTestSurvivor.getDexterity());
        Assertions.assertEquals(expectedAgi, defaultTestSurvivor.getAgility());
        Assertions.assertEquals(expectedEng, defaultTestSurvivor.getEngineering());
        Assertions.assertEquals(expectedHP, defaultTestSurvivor.getHP());
        Assertions.assertEquals(expectedMag, defaultTestSurvivor.getMagic());
        Assertions.assertEquals(expectedStr, defaultTestSurvivor.getStrength());
        Assertions.assertEquals(expectedInt, defaultTestSurvivor.getIntelligence());
        Assertions.assertEquals(expectedGender, defaultTestSurvivor.getGender());
        Assertions.assertEquals(expectedRace, defaultTestSurvivor.getRace());
        Assertions.assertEquals(expectedName, defaultTestSurvivor.getName());
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
        Assertions.assertEquals(expectedAge, testSurvivor.getAge());
        Assertions.assertEquals(expectedDex, testSurvivor.getDexterity());
        Assertions.assertEquals(expectedAgi, testSurvivor.getAgility());
        Assertions.assertEquals(expectedEng, testSurvivor.getEngineering());
        Assertions.assertEquals(expectedHP, testSurvivor.getHP());
        Assertions.assertEquals(expectedmaxHp,testSurvivor.getMaxHp());
        Assertions.assertEquals(expectedMag, testSurvivor.getMagic());
        Assertions.assertEquals(expectedStr, testSurvivor.getStrength());
        Assertions.assertEquals(expectedInt, testSurvivor.getIntelligence());
        Assertions.assertEquals(expectedGender, testSurvivor.getGender());
        Assertions.assertEquals(expectedRace, testSurvivor.getRace());
        Assertions.assertEquals(expectedName, testSurvivor.getName());
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
        Assertions.assertEquals(expectedAge, testSurvivor.getAge());
        Assertions.assertEquals(expectedDex, testSurvivor.getDexterity());
        Assertions.assertEquals(expectedAgi, testSurvivor.getAgility());
        Assertions.assertEquals(expectedEng, testSurvivor.getEngineering());
        Assertions.assertEquals(expectedHP, testSurvivor.getHP());
        Assertions.assertEquals(expectedMag, testSurvivor.getMagic());
        Assertions.assertEquals(expectedStr, testSurvivor.getStrength());
        Assertions.assertEquals(expectedInt, testSurvivor.getIntelligence());
        Assertions.assertEquals(expectedGender, testSurvivor.getGender());
        Assertions.assertEquals(expectedRace, testSurvivor.getRace());
        Assertions.assertEquals(expectedName, testSurvivor.getName());
    }
}