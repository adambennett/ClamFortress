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

import java.util.*;

public class Village {

    private AbstractRegion  biome;
    private Era             currentEra;
    private Double          averageAge = 0.0;

    private Integer agility = 0;
    private Integer strength = 0;
    private Integer intelligence = 0;
    private Integer dexterity = 0;
    private Integer magic = 0;
    private Integer engineering = 0;
    private Integer health = 0;
    private Integer clay = 0;
    private Integer rock = 0;
    private Integer spacegoo = 0;
    private Integer iron = 0;
    private Integer copper = 0;
    private Integer gold = 0;
    private Integer sand = 0;
    private Integer flowers = 0;
    private Integer seeds = 0;
    private Integer brick = 0;
    private Integer lumber = 0;
    private Integer glass = 0;
    private Integer art = 0;
    private Integer jewelery = 0;
    private Integer buildingLimit = 5;

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

    public void addToPopulation(Survivor s) {
        this.population.add(s);
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
        return iron;
    }

    public void setIron(Integer iron) {
        this.iron = iron;
    }

    public Integer getCopper() {
        return copper;
    }

    public void setCopper(Integer copper) {
        this.copper = copper;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
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
}
