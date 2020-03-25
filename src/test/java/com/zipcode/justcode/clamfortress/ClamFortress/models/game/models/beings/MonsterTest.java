package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;

import org.junit.jupiter.api.*;

public class MonsterTest {

    private static Monster testMonster;
    private static Monster nullaryMonster;

    @BeforeEach
    public void setUp() {
        nullaryMonster = new MonsterBuilder().createMonster();
        testMonster = new MonsterBuilder()
                .setAge(100)
                .setDexterity(101)
                .setAgility(102)
                .setEngineering(103)
                .setGender(Gender.MALE)
                .setHealthPoints(200)
                .setMagic(50)
                .setName("Adam")
                .setRace(Race.HUMAN)
                .setStrength(250)
                .setIntelligence(104)
                .createMonster();
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
        Race    expectedRace   = Race.ORC;
        String  expectedName   = "Monster";
        Assertions.assertEquals(expectedAge, nullaryMonster.getAge());
        Assertions.assertEquals(expectedDex, nullaryMonster.getDexterity());
        Assertions.assertEquals(expectedAgi, nullaryMonster.getAgility());
        Assertions.assertEquals(expectedEng, nullaryMonster.getEngineering());
        Assertions.assertEquals(expectedHP, nullaryMonster.getHP());
        Assertions.assertEquals(expectedMag, nullaryMonster.getMagic());
        Assertions.assertEquals(expectedStr, nullaryMonster.getStrength());
        Assertions.assertEquals(expectedInt, nullaryMonster.getIntelligence());
        Assertions.assertEquals(expectedGender, nullaryMonster.getGender());
        Assertions.assertEquals(expectedRace, nullaryMonster.getRace());
        Assertions.assertEquals(expectedName, nullaryMonster.getName());
    }

    @Test
    public void getterTest() {
        Integer expectedAge = 100;
        Integer expectedDex = 101;
        Integer expectedAgi = 102;
        Integer expectedEng = 103;
        Integer expectedHP  = 200;
        Integer expectedMag = 50;
        Integer expectedStr = 250;
        Integer expectedInt = 104;
        Gender  expectedGender = Gender.MALE;
        Race    expectedRace   = Race.HUMAN;
        String  expectedName   = "Adam";
        Assertions.assertEquals(expectedAge, testMonster.getAge());
        Assertions.assertEquals(expectedDex, testMonster.getDexterity());
        Assertions.assertEquals(expectedAgi, testMonster.getAgility());
        Assertions.assertEquals(expectedEng, testMonster.getEngineering());
        Assertions.assertEquals(expectedHP, testMonster.getHP());
        Assertions.assertEquals(expectedMag, testMonster.getMagic());
        Assertions.assertEquals(expectedStr, testMonster.getStrength());
        Assertions.assertEquals(expectedInt, testMonster.getIntelligence());
        Assertions.assertEquals(expectedGender, testMonster.getGender());
        Assertions.assertEquals(expectedRace, testMonster.getRace());
        Assertions.assertEquals(expectedName, testMonster.getName());
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
        testMonster.setAge(200);
        testMonster.setDexterity(201);
        testMonster.setAgility(202);
        testMonster.setEngineering(203);
        testMonster.setHealthPoints(300);
        testMonster.setMagic(250);
        testMonster.setStrength(350);
        testMonster.setIntelligence(204);
        testMonster.setGender(Gender.FEMALE);
        testMonster.setRace(Race.ORC);
        testMonster.setName("Jeremy");
        Assertions.assertEquals(expectedAge, testMonster.getAge());
        Assertions.assertEquals(expectedDex, testMonster.getDexterity());
        Assertions.assertEquals(expectedAgi, testMonster.getAgility());
        Assertions.assertEquals(expectedEng, testMonster.getEngineering());
        Assertions.assertEquals(expectedHP, testMonster.getHP());
        Assertions.assertEquals(expectedMag, testMonster.getMagic());
        Assertions.assertEquals(expectedStr, testMonster.getStrength());
        Assertions.assertEquals(expectedInt, testMonster.getIntelligence());
        Assertions.assertEquals(expectedGender, testMonster.getGender());
        Assertions.assertEquals(expectedRace, testMonster.getRace());
        Assertions.assertEquals(expectedName, testMonster.getName());
    }
}