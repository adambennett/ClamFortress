package clamFortress.models;

import clamFortress.encounters.*;
import clamFortress.encounters.bandits.*;
import clamFortress.encounters.disasters.*;
import clamFortress.encounters.miracles.*;
import clamFortress.encounters.plagues.*;
import clamFortress.encounters.raids.*;
import clamFortress.game.regions.*;
import clamFortress.models.beings.monsters.*;
import clamFortress.models.beings.player.*;
import clamFortress.models.buildings.abstracts.*;
import clamFortress.tech.eras.*;

import java.math.BigInteger;
import java.util.*;

public class Village {

    private AbstractRegion  biome;
    private Era             currentEra;
    private Double          averageAge = 0.0;
    private Inventory       inventory;


    private Integer agility = 0;
    private Integer agilityAvg = 0;
    private Integer strength = 0;
    private Integer strengthAvg = 0;
    private Integer intelligence = 0;
    private Integer intelligenceAvg = 0;
    private Integer dexterity = 0;
    private Integer dexterityAvg = 0;
    private Integer magic = 0;
    private Integer magicAvg =0;
    private Integer engineering = 0;
    private Integer engineeringAvg = 0;
    private Integer health = 0;
    private Integer clay = 0;
    private Integer brick = 0;
    private Integer rock = 0;
    private Integer stone =0;
    private Integer spacegoo = 0;
    private Integer ironOre = 0;
    private Integer copperOre = 0;
    private Integer goldOre = 0;
    private Integer coins = 0;
    private Integer sand = 0;
    private Integer flowers = 0;
    private Integer seeds = 0;
    private Integer wood = 0;
    private Integer lumber = 0;
    private Integer glass = 0;
    private Integer art = 0;
    private Integer jewelery = 0;
    private Integer faith = 0;
    private Integer mana = 0;
    private Integer popCap = 0;
    private Integer buildingLimit = 5;
    private Integer defence = 0;
    private Integer attackPower = 0;

    private ArrayList<Bandit>           occupyingBandits = new ArrayList<>();
    private ArrayList<AbstractBuilding> buildings = new ArrayList<>();
    private ArrayList<AbstractMiracle>  activeMiracles = new ArrayList<>();
    private ArrayList<AbstractDisaster> ongoingDisasters = new ArrayList<>();
    private ArrayList<AbstractPlague>   ongoingPlagues = new ArrayList<>();
    private ArrayList<AbstractRaid>     ongoingOpponentRaids = new ArrayList<>();
    private ArrayList<AbstractRaid>     ongoingFriendlyRaids = new ArrayList<>();
    private ArrayList<Survivor>         population = new ArrayList<>();

    public Village(AbstractRegion biome, Era currentEra) {
        this.biome = biome;
        this.currentEra = currentEra;
        this.inventory = new Inventory();
    }

    public Boolean canRunEncounter(AbstractEncounter encounter) {
        if (encounter instanceof AbstractMiracle) {
            boolean canRunMiracle = true;
            for (AbstractMiracle p : activeMiracles) {
                if (p.getClass().equals(encounter.getClass())) {
                    canRunMiracle = false;
                    break;
                }
            }
            return canRunMiracle;
        } else if (encounter instanceof AbstractDisaster) {
            boolean canRunDisaster = true;
            for (AbstractDisaster p : ongoingDisasters) {
                if (p.getClass().equals(encounter.getClass())) {
                    canRunDisaster = false;
                    break;
                }
            }
            return canRunDisaster;
        } else if (encounter instanceof AbstractPlague) {
            boolean canRunPlague = true;
            for (AbstractPlague p : ongoingPlagues) {
                if (p.getClass().equals(encounter.getClass())) {
                    canRunPlague = false;
                    break;
                }
            }
            return canRunPlague;
        } else {
            return true;
        }
    }

    public ArrayList<Survivor> getSurvivors() {
        return population;
    }

    public void addToPopulation(Survivor s) {
        if (population.size() < popCap) {
            this.population.add(s);
            this.strength += s.getStrength();
            this.agility += s.getAgility();
            this.intelligence += s.getIntelligence();
            this.dexterity += s.getDexterity();
            this.magic += s.getMagic();
            this.engineering += s.getEngineering();
            this.health += s.getHealthPoints();
        }
    }

    public Boolean addBuilding(AbstractBuilding b) {
        if (buildings.size() < buildingLimit) {
            buildings.add(b);
            return true;
        }
        return false;
    }

    public void addBandits(AbstractBandits banditEncounter) {
        this.occupyingBandits.addAll(banditEncounter.getBandits());
    }

    public void reduceBandits(){
        if(occupyingBandits.size() > 0) {
            occupyingBandits.remove(occupyingBandits.size() - 1);
        }
    }

    public void addMiracle(AbstractMiracle m) {
        this.activeMiracles.add(m);
    }

    public void addDisaster(AbstractDisaster d) {
        this.ongoingDisasters.add(d);
    }

    public void addPlague(AbstractPlague p) {
        this.ongoingPlagues.add(p);
    }

    public void addHostileRaid(AbstractRaid r) {
        this.ongoingOpponentRaids.add(r);
    }

    public void addFriendlyRaid(AbstractRaid r) {
        this.ongoingFriendlyRaids.add(r);
    }

    public AbstractRegion getBiome() {
        return biome;
    }

    public Integer getBuildingLimit() {
        return buildingLimit;
    }

    public void setBuildingLimit(Integer buildingLimit) {
        this.buildingLimit = buildingLimit;
    }

    public Era getCurrentEra() {
        return currentEra;
    }

    public Double getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(Double averageAge) {
        this.averageAge = averageAge;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public Integer getMagic() {
        return magic;
    }

    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    public Integer getEngineering() {
        return engineering;
    }

    public void setEngineering(Integer engineering) {
        this.engineering = engineering;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getClay() {
        return clay;
    }

    public void setClay(Integer clay) {
        this.clay = clay;
    }

    public Integer getRock() {
        return rock;
    }

    public void setRock(Integer rock) {
        this.rock = rock;
    }

    public Integer getSpacegoo() {
        return spacegoo;
    }

    public void setSpacegoo(Integer spacegoo) {
        this.spacegoo = spacegoo;
    }

    public Integer getIron() {
        return ironOre;
    }

    public void setIron(Integer iron) {
        this.ironOre = iron;
    }

    public Integer getCopperOre() {
        return copperOre;
    }

    public void setCopperOre(Integer copperOre) {
        this.copperOre = copperOre;
    }

    public Integer getGoldOre() {
        return goldOre;
    }

    public void setGoldOre(Integer goldOre) {
        this.goldOre = goldOre;
    }

    public Integer getSand() {
        return sand;
    }

    public void setSand(Integer sand) {
        this.sand = sand;
    }

    public Integer getFlowers() {
        return flowers;
    }

    public void setFlowers(Integer flowers) {
        this.flowers = flowers;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public void setSeeds(Integer seeds) {
        this.seeds = seeds;
    }

    public Integer getBrick() {
        return brick;
    }

    public void setBrick(Integer brick) {
        this.brick = brick;
    }

    public Integer getLumber() {
        return lumber;
    }

    public void setLumber(Integer lumber) {
        this.lumber = lumber;
    }

    public Integer getGlass() {
        return glass;
    }

    public void setGlass(Integer glass) {
        this.glass = glass;
    }

    public Integer getArt() {
        return art;
    }

    public void setArt(Integer art) {
        this.art = art;
    }

    public Integer getJewelery() {
        return jewelery;
    }

    public void setJewelery(Integer jewelery) {
        this.jewelery = jewelery;
    }

    public Integer getDefense(){
        return this.defence;
    }

    public void setDefence(Integer defence){
        this.defence = defence;
    }

    public void incDefense(Integer incAmount){
        this.defence += incAmount;
    }

    public Integer getAttackPower(){
        return this.attackPower;
    }

    public void setAttackPower(Integer attackPower){
        this.attackPower = attackPower;
    }

    public void incAttack(Integer incAmount){
        this.attackPower+=incAmount;
    }

    public Integer getAgilityAvg() {
        return agilityAvg;
    }

    public void setAgilityAvg() {
        this.agilityAvg = agility/population.size();
    }

    public Integer getStrengthAvg() {
        return strengthAvg;
    }

    public void setStrengthAvg() {
        this.strengthAvg = strength/population.size();
    }

    public Integer getIntelligenceAvg() {
        return intelligenceAvg;
    }

    public void setIntelligenceAvg() {
        this.intelligenceAvg = intelligence/population.size();
    }

    public Integer getDexterityAvg() {
        return dexterityAvg;
    }

    public void setDexterityAvg( ) {
        this.dexterityAvg = dexterity/population.size();
    }

    public Integer getMagicAvg() {
        return magicAvg;
    }

    public void setMagicAvg() {
        this.magicAvg = magic/population.size();
    }

    public Integer getEngineeringAvg() {
        return engineeringAvg;
    }

    public void setEngineeringAvg() {
        this.engineeringAvg = engineering/population.size();
    }

    public void setStone(Integer stone) {
        this.stone = stone;
    }

    public void setWood(Integer wood) {
        this.wood = wood;
    }

    public Integer getWood() {
        return wood;
    }

    public Integer getStone() {
        return stone;
    }

    public Integer getCoins() {
        return coins;
    }

    public Integer getFaith() {
        return faith;
    }

    public Integer getMana() {
        return mana;
    }

    public Integer getPopulation() {
        return population.size();
    }

    public Integer getPopCap() {
        return popCap;
    }

    public void incWood() {
        incWood(1);
    }

    public void incWood(int amt) {
        this.wood = this.wood+=amt;
    }

    public void subWood(int amt) {
        this.wood -= amt;
    }

    public void incStone() {

        incStone(1);
    }

    public void incStone(int amt) {
        this.stone += amt;
    }

    public void subStone(int amt) {
        this.stone -= amt;
    }

    public void incFaith() {
        incFaith(1);
    }

    public void incFaith(int amt) {
        this.faith += amt;
    }

    public void subFaith(int amt) {
        this.faith -= amt;
    }

    public void incMana() {
        incMana(1);
    }

    public void incMana(int amt) {
        this.mana += amt;
    }

    public void subMana(int amt) {
        this.mana -= amt;
    }

    public void incCoins() {
        incCoins(1);
    }

    public void incCoins(int amt) {
        this.coins += amt;
    }

    public void subCoins(int amt) {
        this.coins -= amt;
    }

    public void subPop(Survivor s) {
        this.population.remove(s);
    }

    public void incPopCap() {
        incPopCap(1);
    }

    public void incPopCap(int amt) {
        this.popCap += amt;
    }

    public void subPopCap(int amt) {
        this.popCap = amt;
    }

    public ArrayList<AbstractBuilding> getBuildings() {
        return buildings;
    }
}
