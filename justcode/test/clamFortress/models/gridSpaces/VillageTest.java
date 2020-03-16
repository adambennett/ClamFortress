package clamFortress.models.gridSpaces;

import clamFortress.encounters.*;
import clamFortress.encounters.disasters.*;
import clamFortress.encounters.miracles.*;
import clamFortress.encounters.plagues.*;
import clamFortress.game.regions.*;
import clamFortress.models.beings.player.*;
import clamFortress.tech.eras.*;
import org.junit.*;

import java.util.*;

import static org.junit.Assert.*;

public class VillageTest {

    private static Village village;
    private static AbstractRegion startBiome;

    @Before
    public void setup() {

        startBiome = new Grasslands();
        village = new Village(startBiome);
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
        Integer expectedArt =           10;
        Integer expectedAtkPower =      20;
        Integer expectedBrick =         25;
        Integer expectedCopperOre =     30;
        Integer expectedBuildingLim =   15;
        Integer expectedDefence =       60;
        Integer expectedFlowers =       500;
        Integer expectedGlass =         120;
        Integer expectedGoldOre =       505;
        Integer expectedHunger =        50;
        Integer expectedIron =          67;
        Integer expectedJewelery =      44;
        Integer expectedLumber =        32;
        Integer expectedRock =          97;
        Integer expectedSand =          85;
        Integer expectedSeeds =         945;
        Integer expectedGoo =           444;
        Integer expectedStone =         345;
        Integer expectedWood =          233;
        Integer expectedClay =          9078;

        village.setyPos(expectedYPos);
        village.setxPos(expectedXPos);
        village.setArt(expectedArt);
        village.setAttackPower(expectedAtkPower);
        village.setBrick(expectedBrick);
        village.setCopperOre(expectedCopperOre);
        village.setBuildingLimit(expectedBuildingLim);
        village.setDefence(expectedDefence);
        village.setFlowers(expectedFlowers);
        village.setGlass(expectedGlass);
        village.setGoldOre(expectedGoldOre);
        village.setHunger(expectedHunger);
        village.setIronOre(expectedIron);
        village.setJewelery(expectedJewelery);
        village.setLumber(expectedLumber);
        village.setRock(expectedRock);
        village.setSand(expectedSand);
        village.setSeeds(expectedSeeds);
        village.setSpacegoo(expectedGoo);
        village.setStone(expectedStone);
        village.setWood(expectedWood);
        village.setClay(expectedClay);

        Integer actualYPos = village.getyPos();
        Integer actualXPos = village.getxPos();
        Integer actualArt = village.getArt();
        Integer actualAtk = village.getAttackPower();
        Integer actualBrick = village.getBrick();
        Integer actualCopperOre = village.getCopperOre();
        Integer actualBuildLim = village.getBuildingLimit();
        Integer actualDefence = village.getDefence();
        Integer actualFlowers = village.getFlowers();
        Integer actualGlass = village.getGlass();
        Integer actualGoldOre = village.getGoldOre();
        Integer actualHunger = village.getHunger();
        Integer actualIron = village.getIronOre();
        Integer actualJewelery = village.getJewelery();
        Integer actualLumber = village.getLumber();
        Integer actualRock = village.getRock();
        Integer actualSand = village.getSand();
        Integer actualSeeds = village.getSeeds();
        Integer actualGoo = village.getSpacegoo();
        Integer actualStone = village.getStone();
        Integer actualWood = village.getWood();
        Integer actualClay = village.getClay();

        Assert.assertEquals(expectedYPos, actualYPos);
        Assert.assertEquals(expectedXPos, actualXPos);
        Assert.assertEquals(expectedArt, actualArt);
        Assert.assertEquals(expectedAtkPower, actualAtk);
        Assert.assertEquals(expectedBrick, actualBrick);
        Assert.assertEquals(expectedCopperOre, actualCopperOre);
        Assert.assertEquals(expectedBuildingLim, actualBuildLim);
        Assert.assertEquals(expectedDefence, actualDefence);
        Assert.assertEquals(expectedFlowers, actualFlowers);
        Assert.assertEquals(expectedGlass, actualGlass);
        Assert.assertEquals(expectedGoldOre, actualGoldOre);
        Assert.assertEquals(expectedHunger, actualHunger);
        Assert.assertEquals(expectedIron, actualIron);
        Assert.assertEquals(expectedJewelery, actualJewelery);
        Assert.assertEquals(expectedLumber, actualLumber);
        Assert.assertEquals(expectedRock, actualRock);
        Assert.assertEquals(expectedSand, actualSand);
        Assert.assertEquals(expectedSeeds, actualSeeds);
        Assert.assertEquals(expectedGoo, actualGoo);
        Assert.assertEquals(expectedStone, actualStone);
        Assert.assertEquals(expectedWood, actualWood);
        Assert.assertEquals(expectedClay, actualClay);
    }

    @Test
    public void canRunEncounter() {
        AbstractEncounter fire = new Fire();
        AbstractEncounter bub = new Bubonic();
        AbstractEncounter bless = new Blessing();
        Assert.assertTrue(village.canRunEncounter(fire));
        Assert.assertTrue(village.canRunEncounter(bub));
        Assert.assertTrue(village.canRunEncounter(bless));
        village.addDisaster(new Fire());
        village.addPlague(new Bubonic());
        village.addMiracle(new Blessing());
        Assert.assertFalse(village.canRunEncounter(fire));
        Assert.assertFalse(village.canRunEncounter(bub));
        Assert.assertFalse(village.canRunEncounter(bless));
    }

    @Test
    public void updateAverageStats() {

    }

    @Test
    public void addToPopulation() {
        Survivor test = new Survivor();
        Survivor testB = new Survivor();
        Survivor testC = new Survivor();
        Survivor testD = new Survivor();
        Survivor testE = new Survivor();
        Survivor testF = new Survivor();
        Survivor testG = new Survivor();
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
        Double expectedDub = 20.0;
        Assert.assertEquals(expected, actualInt);
        Assert.assertEquals(expected, actualDex);
        Assert.assertEquals(expected, actualMagic);
        Assert.assertEquals(expected, actualHealth);
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
        AbstractMiracle testM = new Blessing();
        village.addMiracle(testM);
        ArrayList<AbstractMiracle> ongoingM = village.getActiveMiracles();
        Boolean actual = ongoingM.contains(testM);

        Assert.assertTrue(actual);
    }

    @Test
    public void addDisaster() {
        AbstractDisaster testD = new Fire();
        village.addDisaster(testD);
        ArrayList<AbstractDisaster> ongoingD = village.getOngoingDisasters();
        Boolean actual = ongoingD.contains(testD);
        Boolean expected = true;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addPlague() {
        AbstractPlague testP = new Bubonic();
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

        Integer actual = village.getDefence();
        Integer expected = 1060;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incAttack() {
        village.setAttackPower(100);
        village.incAttack(50);

        Integer actual = village.getAttackPower();
        Integer expected = 150;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incWood() {
        village.setWood(100);
        village.incWood();

        Integer actual = village.getWood();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncWood() {
        village.setWood(100);
        village.incWood(100);

        Integer actual = village.getWood();
        Integer expected = 200;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subWood() {
        village.setWood(100);
        village.subWood(150);

        Integer actual = village.getWood();
        Integer expected = 0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incStone() {
        village.setStone(100);
        village.incStone();

        Integer actual = village.getStone();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncStone() {
        village.setStone(100);
        village.incStone(100);

        Integer actual = village.getStone();
        Integer expected = 200;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subStone() {
        village.setStone(100);
        village.subStone(50);

        Integer actual = village.getStone();
        Integer expected = 50;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incFaith() {
        village.setFaith(100);
        village.incFaith();

        Integer actual = village.getFaith();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncFaith() {
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
        village.setMana(100);
        village.incMana();

        Integer actual = village.getMana();
        Integer expected = 101;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncMana() {
        village.setMana(100);
        village.incMana(100);

        Integer actual = village.getMana();
        Integer expected = 200;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subMana() {
        village.setMana(100);
        village.subMana(500);

        Integer actual = village.getMana();
        Integer expected = 0;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void incCoins() {
        village.setCoins(50);
        village.incCoins();

        Integer actual = village.getCoins();
        Integer expected = 51;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testIncCoins() {
        village.setCoins(50);
        village.incCoins(100);

        Integer actual = village.getCoins();
        Integer expected = 150;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subCoins() {
        village.setCoins(50);
        village.subCoins(25);

        Integer actual = village.getCoins();
        Integer expected = 25;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void subPop() {
        Survivor tester = new Survivor();
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