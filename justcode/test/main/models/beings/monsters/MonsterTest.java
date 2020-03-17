package main.models.beings.monsters;

import main.enums.*;
import main.utilities.builders.*;
import org.junit.*;

public class MonsterTest {

    private static Monster testMonster;
    private static Monster nullaryMonster;

    @Before
    public void setUp() {
        nullaryMonster = new Monster();
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
        Race    expectedRace   = Race.HUMAN;
        String  expectedName   = "Monster";
        Assert.assertEquals(expectedAge, nullaryMonster.getAge());
        Assert.assertEquals(expectedDex, nullaryMonster.getDexterity());
        Assert.assertEquals(expectedAgi, nullaryMonster.getAgility());
        Assert.assertEquals(expectedEng, nullaryMonster.getEngineering());
        Assert.assertEquals(expectedHP, nullaryMonster.getHealthPoints());
        Assert.assertEquals(expectedMag, nullaryMonster.getMagic());
        Assert.assertEquals(expectedStr, nullaryMonster.getStrength());
        Assert.assertEquals(expectedInt, nullaryMonster.getIntelligence());
        Assert.assertEquals(expectedGender, nullaryMonster.getGender());
        Assert.assertEquals(expectedRace, nullaryMonster.getRace());
        Assert.assertEquals(expectedName, nullaryMonster.getName());
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
        Assert.assertEquals(expectedAge, testMonster.getAge());
        Assert.assertEquals(expectedDex, testMonster.getDexterity());
        Assert.assertEquals(expectedAgi, testMonster.getAgility());
        Assert.assertEquals(expectedEng, testMonster.getEngineering());
        Assert.assertEquals(expectedHP, testMonster.getHealthPoints());
        Assert.assertEquals(expectedMag, testMonster.getMagic());
        Assert.assertEquals(expectedStr, testMonster.getStrength());
        Assert.assertEquals(expectedInt, testMonster.getIntelligence());
        Assert.assertEquals(expectedGender, testMonster.getGender());
        Assert.assertEquals(expectedRace, testMonster.getRace());
        Assert.assertEquals(expectedName, testMonster.getName());
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
        Assert.assertEquals(expectedAge, testMonster.getAge());
        Assert.assertEquals(expectedDex, testMonster.getDexterity());
        Assert.assertEquals(expectedAgi, testMonster.getAgility());
        Assert.assertEquals(expectedEng, testMonster.getEngineering());
        Assert.assertEquals(expectedHP, testMonster.getHealthPoints());
        Assert.assertEquals(expectedMag, testMonster.getMagic());
        Assert.assertEquals(expectedStr, testMonster.getStrength());
        Assert.assertEquals(expectedInt, testMonster.getIntelligence());
        Assert.assertEquals(expectedGender, testMonster.getGender());
        Assert.assertEquals(expectedRace, testMonster.getRace());
        Assert.assertEquals(expectedName, testMonster.getName());
    }
}