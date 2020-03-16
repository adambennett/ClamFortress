package clamFortress.models.gridSpaces;

import clamFortress.encounters.*;
import clamFortress.encounters.disasters.*;
import clamFortress.encounters.miracles.*;
import clamFortress.encounters.plagues.*;
import clamFortress.game.*;
import clamFortress.game.regions.*;
import clamFortress.tech.eras.*;
import org.junit.*;

import static org.junit.Assert.*;

public class VillageTest {

    private static Village village;
    private static Era startEra;
    private static AbstractRegion startBiome;

    @Before
    public void setup() {

        startBiome = new Grasslands();
        startEra = new BronzeAge();
        village = new Village(startBiome, startEra);
    }

    @Test
    public void constructorTest() {
        Assert.assertNotNull(village);
        Assert.assertEquals(startBiome, village.getBiome());
        Assert.assertEquals(startEra, village.getCurrentEra());
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
        village.setIron(expectedIron);
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
        Integer actualIron = village.getIron();
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
    }

    @Test
    public void addBuilding() {
    }

    @Test
    public void addBandits() {
    }

    @Test
    public void reduceBandits() {
    }

    @Test
    public void addMiracle() {
    }

    @Test
    public void addDisaster() {
    }

    @Test
    public void addPlague() {
    }

    @Test
    public void addHostileRaid() {
    }

    @Test
    public void addFriendlyRaid() {
    }

    @Test
    public void incDefense() {
    }

    @Test
    public void incAttack() {
    }

    @Test
    public void incWood() {
    }

    @Test
    public void testIncWood() {
    }

    @Test
    public void subWood() {
    }

    @Test
    public void incStone() {
    }

    @Test
    public void testIncStone() {
    }

    @Test
    public void subStone() {
    }

    @Test
    public void incFaith() {
    }

    @Test
    public void testIncFaith() {
    }

    @Test
    public void subFaith() {
    }

    @Test
    public void incMana() {
    }

    @Test
    public void testIncMana() {
    }

    @Test
    public void subMana() {
    }

    @Test
    public void incCoins() {
    }

    @Test
    public void testIncCoins() {
    }

    @Test
    public void subCoins() {
    }

    @Test
    public void subPop() {
    }

    @Test
    public void incPopCap() {
    }

    @Test
    public void testIncPopCap() {
    }

    @Test
    public void subPopCap() {
    }
}