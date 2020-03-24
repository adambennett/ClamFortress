package main.models.nodes;

import main.encounters.*;
import main.encounters.disasters.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.models.beings.*;
import main.models.nodes.biomes.*;
import main.utilities.builders.*;
import org.junit.*;

import java.util.*;

public class VillageTest {

    private static Village village;
    private static AbstractBiome startBiome;

    @Before
    public void setup() {
        startBiome = new Grasslands();
        village = new Village(startBiome, 5);
    }

    @Test
    public void constructorTest() {
        Assert.assertNotNull(village);
        Assert.assertEquals(startBiome, village.getBiome());
    }

    @Test
    public void gettersAndSettersTest() {
        Integer expectedYPos =          1;
        Integer expectedXPos =          1;
        Integer expectedBuildingLim =   15;
        Integer expectedHunger =        50;

        village.setyPos(expectedYPos);
        village.setxPos(expectedXPos);
        village.setBuildingLimit(expectedBuildingLim);
        village.setHunger(expectedHunger);

        Integer actualYPos = village.getyPos();
        Integer actualXPos = village.getxPos();
        Integer actualBuildLim = village.getBuildingLimit();
        Integer actualHunger = village.getHunger();

        Assert.assertEquals(expectedYPos, actualYPos);
        Assert.assertEquals(expectedXPos, actualXPos);
        Assert.assertEquals(expectedBuildingLim, actualBuildLim);
        Assert.assertEquals(expectedHunger, actualHunger);
    }

    @Test
    public void canRunEncounter() {
        Integer tempVal = 10;
        AbstractEncounter fire = new Fire(tempVal);
        AbstractEncounter bub = new Bubonic(tempVal);
        AbstractEncounter bless = new ClericBlessing(tempVal);
        Assert.assertTrue(village.canRunEncounter(fire));
        Assert.assertTrue(village.canRunEncounter(bub));
        Assert.assertTrue(village.canRunEncounter(bless));
        village.addDisaster(new Fire(tempVal));
        village.addPlague(new Bubonic(tempVal));
        village.addMiracle(new ClericBlessing(tempVal));
        Assert.assertFalse(village.canRunEncounter(fire));
        Assert.assertFalse(village.canRunEncounter(bub));
        Assert.assertFalse(village.canRunEncounter(bless));
    }

    @Test
    public void updateAverageStats() {

    }

    @Test
    public void addToPopulation() {
        Survivor test = new SurvivorBuilder().createSurvivor();
        Survivor testB = new SurvivorBuilder().createSurvivor();
        Survivor testC = new SurvivorBuilder().createSurvivor();
        Survivor testD = new SurvivorBuilder().createSurvivor();
        Survivor testE = new SurvivorBuilder().createSurvivor();
        Survivor testF = new SurvivorBuilder().createSurvivor();
        Survivor testG = new SurvivorBuilder().createSurvivor();
        test.setAgility(100);
        test.setIntelligence(100);
        test.setDexterity(100);
        test.setMagic(100);
        test.setHealthPoints(60);
        test.setEngineering(100);
        test.setAge(80);
        test.setStrength(100);
        Assert.assertEquals(new Integer(0), village.getAgility());
        village.addToPopulation(test);
        village.addToPopulation(testB);
        village.addToPopulation(testC);
        village.addToPopulation(testD);
        village.addToPopulation(testE);
        village.addToPopulation(testF);
        village.addToPopulation(testG);
        Integer actualAgility = village.getAgility();
        Integer actualSize = village.getSurvivors().size();
        Integer popSize = village.getPopulation();
        Integer actualInt = village.getIntelligence();
        Integer actualDex = village.getDexterity();
        Integer actualMagic = village.getMagic();
        Integer actualHealth = village.getHealth();
        Integer actualTotalAge = village.getTotalAge();
        Integer actualTotalStr = village.getStrength();
        Double actualIntAvg = village.getIntelligenceAvg();
        Double actualDexAvg = village.getDexterityAvg();
        Double actualAgiAvg = village.getAgilityAvg();
        Double actualMagAvg = village.getMagicAvg();
        Double actualEngAvg = village.getEngineeringAvg();
        Double actualAvgAge = village.getAgeAvg();
        Integer expectedSize = 5;
        Integer expected = 100;
        Integer expectedHP = 200;
        Double expectedDub = 20.0;
        Assert.assertEquals(expected, actualInt);
        Assert.assertEquals(expected, actualDex);
        Assert.assertEquals(expected, actualMagic);
        Assert.assertEquals(expectedHP, actualHealth);
        Assert.assertEquals(expected, actualTotalAge);
        Assert.assertEquals(expected, actualTotalStr);
        Assert.assertEquals(expected, actualAgility);
        Assert.assertEquals(expectedDub, actualIntAvg);
        Assert.assertEquals(expectedDub, actualDexAvg);
        Assert.assertEquals(expectedDub, actualAgiAvg);
        Assert.assertEquals(expectedDub, actualMagAvg);
        Assert.assertEquals(expectedDub, actualEngAvg);
        Assert.assertEquals(expectedDub, actualAvgAge);
        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(expectedSize, popSize);
    }

    @Test
    public void addBuilding() {
        //need properbuildings
    }

    @Test
    public void addBandits() {
   //need bandit ecounters
    }

    @Test
    public void reduceBandits() {
        //need bandit encounters
    }

    @Test
    public void addMiracle() {
        Integer tempVal = 10;
        AbstractMiracle testM = new ClericBlessing(tempVal);
        village.addMiracle(testM);
        ArrayList<AbstractMiracle> ongoingM = village.getActiveMiracles();
        Boolean actual = ongoingM.contains(testM);

        Assert.assertTrue(actual);
    }

    @Test
    public void addDisaster() {
        AbstractDisaster testD = new Fire(10);
        village.addDisaster(testD);
        ArrayList<AbstractDisaster> ongoingD = village.getOngoingDisasters();
        Boolean actual = ongoingD.contains(testD);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addPlague() {
        AbstractPlague testP = new Bubonic(10);
        village.addPlague(testP);
        ArrayList<AbstractPlague> ongoing = village.getOngoingPlagues();
        Boolean actual = ongoing.contains(testP);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void addHostileRaid() {
    }

    @Test
    public void addFriendlyRaid() {
    }

    @Test
    public void incDefense() {
        village.setDefence(50);
        village.incDefense(1010);

        Integer actual = village.getDefense();
        Integer expected = 1060;

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void incFaith() {
        village.setFaithLimit(999);
        village.setFaith(100);
        village.incFaith();

        Integer actual = village.getFaith();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncFaith() {
        village.setFaithLimit(999);
        village.setFaith(100);
        village.incFaith(55);

        Integer actual = village.getFaith();
        Integer expected = 155;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subFaith() {
        village.setFaith(100);
        village.subFaith(300);

        Integer actual = village.getFaith();
        Integer expected = 0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incMana() {
        village.setMagic(100);
        village.incMagic();

        Integer actual = village.getMagic();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncMana() {
        village.setMagic(100);
        village.incMagic(100);

        Integer actual = village.getMagic();
        Integer expected = 200;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subMana() {
        village.setMagic(100);
        village.subMagic(500);

        Integer actual = village.getMagic();
        Integer expected = 0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incCoins() {
        Integer firstActual = village.getCoins();
        village.incCoins();
        Integer actual = village.getCoins();
        Integer expected = 1;
        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected, firstActual);
    }

    @Test
    public void testIncCoins() {
        Integer firstActual = village.getCoins();
        village.incCoins(100);

        Integer actual = village.getCoins();
        Integer expected = 100;

        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected, firstActual);
    }

    @Test
    public void subCoins() {
        Integer firstActual = village.getCoins();
        village.incCoins(50);
        village.subCoins(25);
        Integer actual = village.getCoins();
        Integer expected = 25;
        Assert.assertEquals(expected,actual);
        Assert.assertNotEquals(expected, firstActual);
    }

    @Test
    public void subPop() {
        Survivor tester = new SurvivorBuilder().createSurvivor();
        village.addToPopulation(tester);
        village.removeSurvivor(tester);
        Boolean actual = village.containsVillager(tester);
        Boolean expected = false;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incPopCap() {
        village.setPopCap(5);
        village.incPopCap();

        Integer actual = village.getPopCap();
        Integer expected = 6;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncPopCap() {
        village.setPopCap(5);
        village.incPopCap(10);

        Integer actual = village.getPopCap();
        Integer expected = 15;

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void subPopCap() {
        village.setPopCap(5);
        village.subPopCap(2);
        Integer actual = village.getPopCap();
        Integer expected = 3;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testSetPopCap(){
        village.incPopCap(50);
        village.setPopCap(10);

        Integer actual = village.getPopCap();
        Integer expected = 10;

        Assert.assertEquals(expected,actual);
    }
}