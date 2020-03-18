package main.models.nodes;

import main.encounters.*;
import main.encounters.bandits.*;
import main.encounters.disasters.*;
import main.encounters.merchant.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.encounters.raids.*;
import main.enums.*;
import main.models.items.*;
import main.models.managers.*;
import main.models.nodes.biomes.*;
import main.models.*;
import main.models.items.artifacts.*;
import main.models.people.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;

import java.util.*;

public class Village extends AbstractNode {

    private final Inventory inventory;

    // Limits
    private Integer popCap =            5;
    private Integer buildingLimit =     5;
    private Integer foodLimit =         10;
    private Integer resourceLimit =     250;

    // Combat
    private Integer defence =           0;
    private Integer attackPower =       0;

    // Total Stats
    private Integer agility =           0;
    private Integer strength =          0;
    private Integer intelligence =      0;
    private Integer dexterity =         0;
    private Integer magic =             0;
    private Integer engineering =       0;
    private Integer health =            0;
    private Integer totalAge =          0;
    private Integer hunger =            0;
    private Integer famine =            0;
    private Integer food =              0;

    // Average Stats
    private Double ageAvg =             0.0;
    private Double agilityAvg =         0.0;
    private Double strengthAvg =        0.0;
    private Double intelligenceAvg =    0.0;
    private Double dexterityAvg =       0.0;
    private Double magicAvg =           0.0;
    private Double engineeringAvg =     0.0;

    // Resources
    private Integer coins =             0;
    private Integer faith =             0;

    // Lists
    private ArrayList<AbstractResource> resources = new ArrayList<>();
    private ArrayList<Bandit>           occupyingBandits = new ArrayList<>();
    private ArrayList<AbstractBuilding> buildings = new ArrayList<>();
    private ArrayList<AbstractBuilding> uncompletedBuildings = new ArrayList<>();
    private ArrayList<AbstractMiracle>  activeMiracles = new ArrayList<>();
    private ArrayList<AbstractDisaster> ongoingDisasters = new ArrayList<>();
    private ArrayList<AbstractMerchant> vistingMerchants = new ArrayList<>();
    private ArrayList<AbstractPlague>   ongoingPlagues = new ArrayList<>();
    private ArrayList<AbstractRaid>     ongoingOpponentRaids = new ArrayList<>();
    private ArrayList<AbstractRaid>     ongoingFriendlyRaids = new ArrayList<>();
    private ArrayList<Survivor>         population = new ArrayList<>();

    public Village(AbstractBiome biome) {
        super(0, 0, biome);
        this.inventory = new Inventory(3);
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

    public Boolean hasEnoughOfResource(AbstractResource resource, int amt) {
        int sum = 0;
        for (AbstractResource r : resources) {
            if (r.getClass().equals(resource.getClass())) {
                sum++;
            }
        }
        return sum >= amt;
    }

    public void updateAverageStats() {
        this.ageAvg =             (double)this.totalAge / (double)this.population.size();
        this.agilityAvg =         (double)this.agility / (double) this.population.size();
        this.strengthAvg =        (double)this.strength / (double) this.population.size();
        this.intelligenceAvg =    (double)this.intelligence / (double) this.population.size();
        this.dexterityAvg =       (double)this.dexterity / (double) this.population.size();
        this.magicAvg =           (double)this.magic / (double) this.population.size();
        this.engineeringAvg =     (double)this.engineering / (double) this.population.size();
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
            this.totalAge += s.getAge();
            updateAverageStats();
            for (AbstractItem item : inventory.getItems()) {
                item.onNewCitizen(s);
            }
        }
    }

    public void updateAfterRemoving(Survivor s) {
        this.strength -= s.getStrength();
        this.agility -= s.getAgility();
        this.intelligence -= s.getIntelligence();
        this.dexterity -= s.getDexterity();
        this.magic -= s.getMagic();
        this.engineering -= s.getEngineering();
        this.health -= s.getHealthPoints();
        this.totalAge -= s.getAge();
        updateAverageStats();
        for (AbstractItem item : inventory.getItems()) {
            item.onLoseCitizen(s);
        }
    }

    public Boolean addBuilding(AbstractBuilding b) {
        if (buildings.size() < buildingLimit) {
            buildings.add(b);
            for (AbstractItem item : inventory.getItems()) {
                item.onNewBuilding(b);
            }
            return true;
        }
        return false;
    }

    public Boolean addUncompletedBuilding(AbstractBuilding b) {
        return uncompletedBuildings.add(b);
    }

    public void reduceBandits(){
        if(occupyingBandits.size() > 0) {
            occupyingBandits.remove(occupyingBandits.size() - 1);
        }
    }

    public Boolean containsVillager(Survivor s){
        for (Survivor sur: population) {
            if (sur.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void addResource(AbstractResource resource, int amt) {
        for (int i = 0; i < amt; i++) {
            if (this.resources.size() < this.resourceLimit) {
                this.resources.add(resource);
            } else {
                OutputManager.addToBot("Not enough room to accumulate more resources! Build some storehouses.", OutputFlag.RESOURCES_FULL);
            }
        }
    }


    public void addResource(AbstractResource resource) {
        addResource(resource, 1);
    }

    public void addMerchant(AbstractMerchant merchant) {
        this.vistingMerchants.add(merchant);
    }

    public void addMiracle(AbstractMiracle m) {
        if (this.canRunEncounter(m)) {
            this.activeMiracles.add(m);
            for (AbstractItem item : inventory.getItems()) {
                item.onNewMiracle(m);
            }
        }
    }
    public void addDisaster(AbstractDisaster d) {
        if (this.canRunEncounter(d)) {
            this.ongoingDisasters.add(d);
            for (AbstractItem item : inventory.getItems()) {
                item.onNewDisaster(d);
            }
        }
    }
    public void addPlague(AbstractPlague p) {
        if (this.canRunEncounter(p)) {
            this.ongoingPlagues.add(p);
            for (AbstractItem item : inventory.getItems()) {
                item.onNewPlague(p);
            }
        }
    }

    // Setters
    public void setPopCap(Integer popCap){this.popCap = popCap;}
    public void setHunger(Integer hunger) {
        this.hunger = hunger;
        if (this.hunger > 100) {
            this.hunger = 100;
        }
        if (this.hunger < 0) {
            this.hunger = 0;
        }
    }
    public void setBuildingLimit(Integer buildingLimit) {
        this.buildingLimit = buildingLimit;
    }
    public void setCoins(Integer coins){
     this.coins=coins;
    }
    public void setDefence(Integer defence){
        this.defence = defence;
    }
    public void setAttackPower(Integer attackPower){
        this.attackPower = attackPower;
    }
    public void setFaith(Integer faith){
        this.faith = faith;
    }
    public void setFood(Integer food) {
        this.food = food;
    }
    public void setFamine(Integer famine) {
        this.famine = famine;
    }
    public void setMagic(Integer magic) {
        this.magic = magic;
    }

    // Getters
    public Integer getHunger() {
        return hunger;
    }
    public Integer getBuildingLimit() {
        return buildingLimit;
    }
    public Double getAgeAvg() {
        return ageAvg;
    }
    public Integer getAgility() {
        return agility;
    }
    public Integer getStrength() {
        return strength;
    }
    public Integer getIntelligence() {
        return intelligence;
    }
    public Integer getDexterity() {
        return dexterity;
    }
    public Integer getMagic() {
        return magic;
    }
    public Integer getEngineering() {
        return engineering;
    }
    public Integer getHealth() {
        return health;
    }
    public Integer getFood() {
        return food;
    }
    public Double getAgilityAvg() {
        return agilityAvg;
    }
    public Double getStrengthAvg() {
        return strengthAvg;
    }
    public Double getIntelligenceAvg() {
        return intelligenceAvg;
    }
    public Double getDexterityAvg() {
        return dexterityAvg;
    }
    public Double getMagicAvg() {
        return magicAvg;
    }
    public Double getEngineeringAvg() {
        return engineeringAvg;
    }

    public Integer getFoodLimit() {
        return foodLimit;
    }

    public Integer getResourceLimit() {
        return resourceLimit;
    }

    public Integer getDefense(){
        int atk = this.defence;
        for (AbstractItem a : inventory.getItems()) {
            atk += a.modifyDef();
        }
        return atk;
    }
    public Integer getAttackPower(){
        int atk = this.attackPower;
        for (AbstractItem a : inventory.getItems()) {
            atk += a.modifyAtk();
        }
        return atk;
    }
    public Integer getCoins() {
        return this.coins;
    }
    public Integer getFaith() {
        return this.faith;
    }
    public Integer getPopulation() {
        return this.population.size();
    }
    public Integer getPopCap() {
        return this.popCap;
    }
    public Integer getTotalAge() {
        return totalAge;
    }
    public Integer getFamine() {
        return famine;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public ArrayList<AbstractResource> getResources() {
        return resources;
    }
    public ArrayList<Survivor> getSurvivors() {
        return population;
    }
    public ArrayList<AbstractBuilding> getBuildings() {
        return buildings;
    }
    public ArrayList<AbstractBuilding> getUncompletedBuildings() {
        return uncompletedBuildings;
    }
    public ArrayList<AbstractMiracle> getActiveMiracles() {
        return activeMiracles;
    }
    public ArrayList<AbstractDisaster> getOngoingDisasters() {
        return ongoingDisasters;
    }
    public ArrayList<AbstractPlague> getOngoingPlagues() {
        return ongoingPlagues;
    }
    public ArrayList<AbstractMerchant> getVistingMerchants() {
        return vistingMerchants;
    }


    public void setFoodLimit(Integer foodLimit) {
        this.foodLimit = foodLimit;
    }

    public void setResourceLimit(Integer resourceLimit) {
        this.resourceLimit = resourceLimit;
    }

    public void incDefense(Integer incAmount){
        this.defence += incAmount;
    }

    public void incAttack(Integer incAmount){
        this.attackPower+=incAmount;
    }

    public void incFood(int amt){
        this.food += amt;
        if (this.food > this.foodLimit) {
            this.food = this.foodLimit;
        }
    }

    public void incFaith() {
        incFaith(1);
    }

    public void incFaith(int amt) {
        this.faith += amt;
    }

    public void incMagic() {
        incMagic(1);
    }

    public void incMagic(int amt) {
        this.magic += amt;
    }

    public void incCoins() {
        incCoins(1);
    }

    public void incCoins(int amt) {
        this.coins += amt;
    }

    public void incPopCap() {
        incPopCap(1);
    }

    public void incPopCap(int amt) {
        this.popCap += amt;
    }

    public void subPopCap(int amt) {
        this.popCap -= amt;
        if(this.popCap <0){
            this.popCap = 0;
        }
    }

    public void subCoins(int amt) {
        this.coins -= amt;
        if(this.coins <0){
            this.coins = 0;
        }
    }

    public void removeSurvivor(Survivor s) {
        this.population.remove(s);
    }

    public void subMagic(int amt) {
        this.magic -= amt;
        if(this.magic < 0){
            this.magic = 0;
        }
    }
    public void subFaith(int amt) {
        this.faith -= amt;
        if(this.faith < 0){
            this.faith = 0;
        }
    }

    @Override
    public String toString() {
        return "Village";
    }
}
