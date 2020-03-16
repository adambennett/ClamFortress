package clamFortress.models.gridSpaces;

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
        village.setyPos(1);
        village.setxPos(1);
        village.setArt(10);
        village.setAttackPower(20);
        village.setBrick(25);
        village.setCopperOre(30);
        village.setBuildingLimit(15);
        village.setDefence(60);
        village.setFlowers(500);
        village.setGlass(120);
        village.setGoldOre(505);
        village.setHunger(50);
        village.setIron(67);
        village.setJewelery(44);
        village.setLumber(32);
        village.setRock(97);
        village.setSand(85);
        village.setSeeds(945);
        village.setSpacegoo(444);
        village.setStone(345);
        village.setWood(233);

    }

    @Test
    public void canRunEncounter() {
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