package main.models.nodes;

import main.encounters.*;
import main.encounters.disasters.*;
import main.encounters.merchant.*;
import main.encounters.miracles.*;
import main.encounters.plagues.*;
import main.encounters.raids.*;
import main.enums.*;
import main.interfaces.*;
import main.models.items.*;
import main.models.items.military.armor.*;
import main.models.items.military.weapons.*;
import main.models.managers.*;
import main.models.nodes.biomes.*;
import main.models.*;
import main.models.people.*;
import main.models.buildings.abstracts.*;
import main.models.resources.*;
import main.models.resources.refined.food.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

public class Village extends AbstractNode {

    private final Inventory inventory;
    private final AbstractNode baseNode;

    // Limits
    private Integer popCap =            5;
    private Integer buildingLimit =     5;
    private Integer foodLimit =         10;
    private Integer resourceLimit =     250;
    private Integer coinLimit =         500;
    private Integer faithLimit =        100;

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
    private Integer maxHP =             0;
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
    private Map<AbstractResource, Integer> resources;

    @Override public String toString() { return "Village"; }

    public Village(AbstractBiome biome, int popCap) {
        super(0, 0, biome);
        this.inventory = new Inventory(3);
        this.resources = new HashMap<>();
        this.popCap = popCap;
        this.baseNode = getNodeFromBiome(biome);
    }

    // Fake Village for proper Archive creation
    public Village() {
        super();
        this.baseNode = null;
        this.inventory = new Inventory(0);
    }

    public AbstractNode getNodeFromBiome(AbstractBiome biome) {
        if (biome instanceof DesertBiome) {
            return new Desert(0, 0);
        }else if (biome instanceof Forest) {
            return new Jungle(0, 0);
        }else if (biome instanceof Grasslands) {
            return new Grass(0, 0);
        }else if (biome instanceof Icelands) {
            return new Tundra(0, 0);
        }else if (biome instanceof Mountainous) {
            return new Mountain(0, 0);
        }else if (biome instanceof Ocean) {
            return new Sea(0, 0);
        } else {
            Logger.getGlobal().warning("Got a bad biome type for village at creation time!");
        }
        return null;
    }

    // INVENTORY /////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean addToInventory(String key) {
        if (Archive.getInstance().getItem(key) != null) {
            AbstractItem item = Archive.getInstance().getItem(key);
            return inventory.addItem(item);
        }
        return false;
    }
    // END INVENTORY /////////////////////////////////////////////////////////////////////////////////////////////

    // COMBAT    /////////////////////////////////////////////////////////////////////////////////////////////////
    public Integer dealDamage() {
        Integer dmg = this.getAttackPower();
        for (AbstractItem i : getInventory().getItems()) {
            if (i instanceof Projectile) {
                dmg += ((Projectile) i).fire();
            }
        }
        OutputManager.addToBot("Dealt " + dmg + " damage in a raid against " + GameManager.getInstance().getRaidingCity().cityName() + ".\nEnemy City HP: " + GameManager.getInstance().getRaidingCity().getHp() + " / " + GameManager.getInstance().getRaidingCity().getMaxHP());
        if (dmg < 1) { return 0; }
        return ThreadLocalRandom.current().nextInt(0, dmg);
    }

    public void takeDamage(int amt) {
        amt -= this.defence;
        if (this.population.size() > 0) {
            takeDamage(this.population.get(ThreadLocalRandom.current().nextInt(this.population.size())), amt);
        }
    }

    private void takeDamage(Survivor villager, int amt) {
        villager.setHealthPoints(villager.getHP() - amt);
        if (villager.getHP() < 1) {
            removeSurvivor(villager);
            OutputManager.addToBot(villager.getName() + " has died in a raid against " + GameManager.getInstance().getRaidingCity().cityName() + "!");
        } else {
            OutputManager.addToBot(villager.getName() + " took " + amt + " damage in a raid against " + GameManager.getInstance().getRaidingCity().cityName());
        }
        updateHP();
    }
    // END COMBAT ////////////////////////////////////////////////////////////////////////////////////////////////

    // VILLAGERS /////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean hasSurvivorByThatName(String name) {
        for (Survivor s : population) {
            if (s.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void updateHP() {
        this.health = 0;
        this.maxHP = 0;
        for (Survivor s : this.population) {
            this.maxHP += s.getMaxHp();
            this.health += s.getHP();
        }
    }

    public Boolean addToPopulation(Survivor s) {
        if (population.size() < popCap) {
            for (GameObject obj : Game.getModifierObjects()) {
                s = obj.onNewCitizen(s);
            }
            this.population.add(s);
            this.strength += s.getStrength();
            this.agility += s.getAgility();
            this.intelligence += s.getIntelligence();
            this.dexterity += s.getDexterity();
            this.magic += s.getMagic();
            this.engineering += s.getEngineering();
            this.health += s.getHP();
            this.maxHP += s.getMaxHp();
            this.totalAge += s.getAge();
            updateAverageStats();
            return true;
        }
        return false;
    }

    public void updateAfterRemoving(Survivor s) {
        this.strength -= s.getStrength();
        this.agility -= s.getAgility();
        this.intelligence -= s.getIntelligence();
        this.dexterity -= s.getDexterity();
        this.magic -= s.getMagic();
        this.engineering -= s.getEngineering();
        this.health -= s.getHP();
        this.maxHP -= s.getMaxHp();
        this.totalAge -= s.getAge();
        updateAverageStats();
        for (GameObject obj : Game.getModifierObjects()) {
            obj.onLoseCitizen(s);
        }
    }

    private void updateAverageStats() {
        this.ageAvg =             (double)this.totalAge / (double)this.population.size();
        this.agilityAvg =         (double)this.agility / (double) this.population.size();
        this.strengthAvg =        (double)this.strength / (double) this.population.size();
        this.intelligenceAvg =    (double)this.intelligence / (double) this.population.size();
        this.dexterityAvg =       (double)this.dexterity / (double) this.population.size();
        this.magicAvg =           (double)this.magic / (double) this.population.size();
        this.engineeringAvg =     (double)this.engineering / (double) this.population.size();
    }

    public Boolean containsVillager(Survivor s){
        for (Survivor sur: population) {
            if (sur.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void removeSurvivor(Survivor s) {
        for (int i = 0; i < this.population.size(); i++) {
            if (this.population.get(i).equals(s)) {
                updateAfterRemoving(this.population.remove(i));
            }
        }
    }

    public Survivor removeRandomSurvivor() {
        if (this.population.size() > 0) {
            Survivor output = this.population.remove(ThreadLocalRandom.current().nextInt(this.population.size()));
            updateAverageStats();
            return output;
        }
        return null;
    }

    public Integer feedAllVillagers() {
        int output = 0;
        for (Survivor s : population) {
            if (this.food>0) {
                this.food--;
                int healAmt = 100;
                if (Game.getDifficulty().compareTo(Difficulty.IMPOSSIBLE) >= 0) {
                    healAmt = 10;
                } else if (Game.getDifficulty().compareTo(Difficulty.NIGHTMARE) >= 0) {
                    healAmt = 15;
                } else if (Game.getDifficulty().compareTo(Difficulty.BRUTAL) >= 0) {
                    healAmt = 25;
                } else if (Game.getDifficulty().compareTo(Difficulty.HARD) >= 0) {
                    healAmt = 40;
                } else if (Game.getDifficulty().compareTo(Difficulty.DEFAULT) >= 0) {
                    healAmt = 50;
                }
                s.feed(new PlaceholderFood(healAmt));
            } else{
                output++;
            }
        }
        return output;
    }
    // END VILLAGERS /////////////////////////////////////////////////////////////////////////////////////////////

    // BUILDINGS     /////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean addBuilding(AbstractBuilding b) {
        if (buildings.size() < buildingLimit) {
            buildings.add(b);
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onNewBuilding(b);
            }
            return true;
        }
        return false;
    }

    public void addUncompletedBuilding(AbstractBuilding b) {
        uncompletedBuildings.add(b);
    }

    public Boolean hasBuilding(String building) {
        if (Archive.getInstance().getBuilding(building) != null) {
            AbstractBuilding res = Archive.getInstance().getBuilding(building);
            return this.buildings.contains(res);
        }
        return false;
    }
    // END BUILDINGS /////////////////////////////////////////////////////////////////////////////////////////////

    // RESOURCES     /////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean hasEnoughOfResource(String resource, int amt) {
        if (Archive.getInstance().getRes(resource) != null) {
            AbstractResource res = Archive.getInstance().getRes(resource);
            if ((this.resources.get(res) != null)) {
                int check = this.resources.get(res);
                return check >= amt;
            }
        }
        return false;
    }

    public Integer totalResources() {
        return getAllResources().size();
    }

    public Boolean addResources(ArrayList<AbstractResource> resources) {
        if (resources.size() + totalResources() <= this.resourceLimit) {
            for (AbstractResource r : resources) {
                addResource(r);
            }
            return true;
        } else {
            OutputManager.addToBot(OutputFlag.RESOURCES_FULL, "Not enough room to accumulate more resources! Build some storehouses.");
            return false;
        }
    }

    public Boolean addResource(AbstractResource resource) {
        return addResource(resource, 1);
    }

    public Boolean addResources(Map<AbstractResource, Integer> resources) {
        int resourcesSize = 0;
        for (Map.Entry<AbstractResource, Integer> entry : resources.entrySet()) {
            resourcesSize += entry.getValue();
        }
        if (resourcesSize + this.totalResources() <= this.resourceLimit) {
            for (Map.Entry<AbstractResource, Integer> entry : resources.entrySet()) {
                if (this.resources.containsKey(entry.getKey())) {
                    this.resources.put(entry.getKey(), entry.getValue() + this.resources.get(entry.getKey()));
                } else {
                    this.resources.put(entry.getKey(), entry.getValue());
                }
                entry.getKey().onObtain();
            }
            return true;
        } else {
            OutputManager.addToBot(OutputFlag.RESOURCES_FULL, "Not enough room to accumulate more resources! Build some storehouses.");
            return false;
        }
    }

    public Boolean addResource(AbstractResource resource, int amt) {
        boolean reduced = false;
        while (totalResources() + amt > this.resourceLimit && amt > 0) {
            amt--;
            reduced = true;
        }
        if (totalResources() + amt <= this.resourceLimit && amt > 0) {
            if (this.resources.containsKey(resource)) {
                this.resources.put(resource, this.resources.get(resource) + amt);
            } else {
                this.resources.put(resource, amt);
            }
            resource.onObtain();
            return true;
        } else if (reduced) {
            OutputManager.addToBot(OutputFlag.RESOURCES_FULL, "Not enough room to accumulate more resources! Build some storehouses.");
            return false;
        }
        return false;
    }

    public Integer removeResource(String resource) {
        return removeResource(resource, 0, true);
    }

    public Integer removeResource(String resource, int amt) {
        return removeResource(resource, amt, false);
    }

    private Integer removeResource(String resource, int amt, boolean all) {
        if (Archive.getInstance().getRes(resource) != null) {
            AbstractResource res = Archive.getInstance().getRes(resource);
            if ((this.resources.get(res) != null)) {
                if (all || this.resources.get(res) < amt) {
                    return this.resources.remove(res);
                }
                this.resources.put(res, this.resources.get(res) - amt);
            }
        }
        return 0;
    }

    public Boolean containsResource(String resource) {
        return Archive.getInstance().getRes(resource) != null && this.resources.containsKey(Archive.getInstance().getRes(resource));
    }

    public Integer getResource(String resource) {
        return Archive.getInstance().getRes(resource) != null ? this.resources.get(Archive.getInstance().getRes(resource)) : 0;
    }

    public ArrayList<AbstractResource> getAllResources() {
        ArrayList<AbstractResource> output = new ArrayList<>();
        for (Map.Entry<AbstractResource, Integer> entry : this.resources.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                output.add(entry.getKey().clone());
            }
        }
        return output;
    }
    // END RESOURCES /////////////////////////////////////////////////////////////////////////////////////////////

    // ENCOUNTERS    /////////////////////////////////////////////////////////////////////////////////////////////
    public void addMerchant(AbstractMerchant merchant) {
        this.vistingMerchants.add(merchant);
    }

    public void addMiracle(AbstractMiracle m) {
        if (this.canRunEncounter(m)) {
            this.activeMiracles.add(m);
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onNewMiracle(m);
            }
        }
    }
    public void addDisaster(AbstractDisaster d) {
        if (this.canRunEncounter(d)) {
            this.ongoingDisasters.add(d);
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onNewDisaster(d);
            }
        }
    }
    public void addPlague(AbstractPlague p) {
        if (this.canRunEncounter(p)) {
            this.ongoingPlagues.add(p);
            for (GameObject obj : Game.getModifierObjects()) {
                obj.onNewPlague(p);
            }
        }
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

    public void reduceBandits(){
        if(occupyingBandits.size() > 0) {
            occupyingBandits.remove(occupyingBandits.size() - 1);
        }
    }
    // END ENCOUNTERS ////////////////////////////////////////////////////////////////////////////////////////////

    // GETTERS & SETTERS /////////////////////////////////////////////////////////////////////////////////////////
    public Integer getDefense(){
        int def = this.defence;
        ArrayList<GameObject> objs = Game.getModifierObjects();
        for (GameObject obj : objs) {
            def += obj.modifyDef();
            if (obj instanceof AbstractArmor) {
                for (GameObject plating : objs) {
                    def += plating.modifyArmorDef((AbstractArmor) obj);
                }
            }
        }
        return def;
    }
    public Integer getAttackPower(){
        int atk = this.attackPower;
        ArrayList<GameObject> objs = Game.getModifierObjects();
        for (GameObject obj : objs) {
            atk += obj.modifyAtk();
            if (obj instanceof AbstractWeapon) {
                for (GameObject ammo : objs) {
                    atk += ammo.modifyWeaponDmg((AbstractWeapon) obj);
                }
            }
        }
        return atk;
    }

    public AbstractNode getBaseNode() {
        return baseNode;
    }

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
    public Integer getMaxHP() {
        return maxHP;
    }
    public Integer getFaithLimit() {
        return faithLimit;
    }

    public Integer getCoinLimit() {
        return coinLimit;
    }

    public Integer getFoodLimit() {
        return foodLimit;
    }

    public Integer getResourceLimit() {
        return resourceLimit;
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

    public void incDefense(Integer amt){
        this.defence += amt;
    }

    public void incAttack(Integer amt){
        this.attackPower += amt;
    }

    public void incFaith() {
        incFaith(1);
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

    public void incPopCap() {
        incPopCap(1);
    }

    public void incPopCap(int amt) {
        this.popCap += amt;
    }

    public void incFood(int amt){
        this.food += amt; if (this.food > this.foodLimit) { this.food = this.foodLimit; }
    }

    public void incFaith(int amt) {
        this.faith += amt; if (this.faith > this.faithLimit) { this.faith = this.faithLimit; }
    }

    public void incCoins(int amt) {
        this.coins += amt; if (this.coins > this.coinLimit) { this.coins = this.coinLimit; }
    }

    public void subMagic(int amt) {
        this.magic -= amt; if (this.magic < 0) { this.magic = 0; }
    }
    public void subFaith(int amt) {
        this.faith -= amt; if (this.faith < 0) { this.faith = 0; }
    }

    public void subPopCap(int amt) {
        this.popCap -= amt; if (this.popCap < 0) { this.popCap = 0; }
    }

    public void subCoins(int amt) {
        this.coins -= amt; if (this.coins < 0) { this.coins = 0; }
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
        if (this.hunger > 100) { this.hunger = 100; }
        else if (this.hunger < 0) { this.hunger = 0; }
    }

    public void setMaxHP(Integer maxHP) { this.maxHP = maxHP; }
    public void setPopCap(Integer popCap){ this.popCap = popCap; }
    public void setHealth(Integer health) { this.health = health; }
    public void setBuildingLimit(Integer buildingLimit) {
        this.buildingLimit = buildingLimit;
    }
    public void setCoins(Integer coins){
        this.coins = coins;
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
    public void setFoodLimit(Integer foodLimit) {
        this.foodLimit = foodLimit;
    }
    public void setResourceLimit(Integer resourceLimit) {
        this.resourceLimit = resourceLimit;
    }
    public void setCoinLimit(Integer coinLimit) {
        this.coinLimit = coinLimit;
    }
    public void setFaithLimit(Integer faithLimit) {
        this.faithLimit = faithLimit;
    }
    public void setyPos(int y) { this.yPos = y; }
    public void setxPos(int x) { this.xPos = x; }
    // END GETTERS & SETTERS /////////////////////////////////////////////////////////////////////////////////////
}
