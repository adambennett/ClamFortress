package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.builders.*;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class VillageTest {

    @Test
    public void constructorTest() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Assertions.assertNotNull(village);
        Assertions.assertEquals(startBiome, village.getBiome());
    }

    @Test
    public void gettersAndSettersTest() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);

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

        Assertions.assertEquals(expectedYPos, actualYPos);
        Assertions.assertEquals(expectedXPos, actualXPos);
        Assertions.assertEquals(expectedBuildingLim, actualBuildLim);
        Assertions.assertEquals(expectedHunger, actualHunger);
    }

    @Test
    public void canRunEncounter() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);

        Integer tempVal = 10;
        AbstractEncounter fire = new Fire(tempVal);
        AbstractEncounter bub = new Bubonic(tempVal);
        AbstractEncounter bless = new ClericBlessing(tempVal);
        Assertions.assertTrue(village.canRunEncounter(fire));
        Assertions.assertTrue(village.canRunEncounter(bub));
        Assertions.assertTrue(village.canRunEncounter(bless));
        village.addDisaster(new Fire(tempVal));
        village.addPlague(new Bubonic(tempVal));
        village.addMiracle(new ClericBlessing(tempVal));
        Assertions.assertFalse(village.canRunEncounter(fire));
        Assertions.assertFalse(village.canRunEncounter(bub));
        Assertions.assertFalse(village.canRunEncounter(bless));
    }

    @Test
    public void updateAverageStats() {

    }

    @Test
    public void addToPopulation() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);

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
        Assertions.assertEquals(new Integer(0), village.getAgility());
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
        Assertions.assertEquals(expected, actualInt);
        Assertions.assertEquals(expected, actualDex);
        Assertions.assertEquals(expected, actualMagic);
        Assertions.assertEquals(expectedHP, actualHealth);
        Assertions.assertEquals(expected, actualTotalAge);
        Assertions.assertEquals(expected, actualTotalStr);
        Assertions.assertEquals(expected, actualAgility);
        Assertions.assertEquals(expectedDub, actualIntAvg);
        Assertions.assertEquals(expectedDub, actualDexAvg);
        Assertions.assertEquals(expectedDub, actualAgiAvg);
        Assertions.assertEquals(expectedDub, actualMagAvg);
        Assertions.assertEquals(expectedDub, actualEngAvg);
        Assertions.assertEquals(expectedDub, actualAvgAge);
        Assertions.assertEquals(expectedSize, actualSize);
        Assertions.assertEquals(expectedSize, popSize);
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
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Integer tempVal = 10;
        AbstractMiracle testM = new ClericBlessing(tempVal);
        village.addMiracle(testM);
        ArrayList<AbstractMiracle> ongoingM = village.getActiveMiracles();
        Boolean actual = ongoingM.contains(testM);

        Assertions.assertTrue(actual);
    }

    @Test
    public void addDisaster() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        AbstractDisaster testD = new Fire(10);
        village.addDisaster(testD);
        ArrayList<AbstractDisaster> ongoingD = village.getOngoingDisasters();
        Boolean actual = ongoingD.contains(testD);
        Boolean expected = true;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void addPlague() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        AbstractPlague testP = new Bubonic(10);
        village.addPlague(testP);
        ArrayList<AbstractPlague> ongoing = village.getOngoingPlagues();
        Boolean actual = ongoing.contains(testP);
        Boolean expected = true;

        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void addHostileRaid() {
    }

    @Test
    public void addFriendlyRaid() {
    }

    @Test
    public void incDefense() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setDefence(50);
        village.incDefense(1010);

        Integer actual = village.getDefense();
        Integer expected = 1060;

        Assertions.assertEquals(expected,actual);
    }


    @Test
    public void incFaith() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setFaithLimit(999);
        village.setFaith(100);
        village.incFaith();

        Integer actual = village.getFaith();
        Integer expected = 101;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testIncFaith() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setFaithLimit(999);
        village.setFaith(100);
        village.incFaith(55);

        Integer actual = village.getFaith();
        Integer expected = 155;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void subFaith() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setFaith(100);
        village.subFaith(300);

        Integer actual = village.getFaith();
        Integer expected = 0;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void incMana() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setMagic(100);
        village.incMagic();

        Integer actual = village.getMagic();
        Integer expected = 101;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testIncMana() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setMagic(100);
        village.incMagic(100);

        Integer actual = village.getMagic();
        Integer expected = 200;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void subMana() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setMagic(100);
        village.subMagic(500);

        Integer actual = village.getMagic();
        Integer expected = 0;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void incCoins() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Integer firstActual = village.getCoins();
        village.incCoins();
        Integer actual = village.getCoins();
        Integer expected = 1;
        Assertions.assertEquals(expected,actual);
        Assertions.assertNotEquals(expected, firstActual);
    }

    @Test
    public void testIncCoins() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Integer firstActual = village.getCoins();
        village.incCoins(100);

        Integer actual = village.getCoins();
        Integer expected = 100;

        Assertions.assertEquals(expected,actual);
        Assertions.assertNotEquals(expected, firstActual);
    }

    @Test
    public void subCoins() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Integer firstActual = village.getCoins();
        village.incCoins(50);
        village.subCoins(25);
        Integer actual = village.getCoins();
        Integer expected = 25;
        Assertions.assertEquals(expected,actual);
        Assertions.assertNotEquals(expected, firstActual);
    }

    @Test
    public void subPop() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        Survivor tester = new SurvivorBuilder().createSurvivor();
        village.addToPopulation(tester);
        village.removeSurvivor(tester);
        Boolean actual = village.containsVillager(tester);
        Boolean expected = false;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void incPopCap() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setPopCap(5);
        village.incPopCap();

        Integer actual = village.getPopCap();
        Integer expected = 6;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testIncPopCap() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setPopCap(5);
        village.incPopCap(10);

        Integer actual = village.getPopCap();
        Integer expected = 15;

        Assertions.assertEquals(expected,actual);

    }

    @Test
    public void subPopCap() {
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.setPopCap(5);
        village.subPopCap(2);
        Integer actual = village.getPopCap();
        Integer expected = 3;

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testSetPopCap(){
        AbstractBiome startBiome = new Grasslands();
        Village village = new Village(startBiome, 5);
        village.incPopCap(50);
        village.setPopCap(10);

        Integer actual = village.getPopCap();
        Integer expected = 10;

        Assertions.assertEquals(expected,actual);
    }
}