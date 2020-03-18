package main.models;

import main.enums.*;
import main.models.animals.*;
import main.models.animals.desert.*;
import main.models.animals.jungle.*;
import main.models.animals.land.*;
import main.models.animals.land.bears.*;
import main.models.animals.mountain.*;
import main.models.animals.sea.*;
import main.models.animals.tundra.*;
import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.defending.*;
import main.models.buildings.concrete.faith.*;
import main.models.buildings.concrete.housing.*;
import main.models.buildings.concrete.refining.*;
import main.models.buildings.concrete.refining.crafting.*;
import main.models.buildings.concrete.storing.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.items.medical.*;
import main.models.items.military.*;
import main.models.items.tools.*;
import main.models.items.tools.crafting.*;
import main.models.items.tools.engineering.*;
import main.models.items.tools.gathering.*;
import main.models.items.tools.hunting.*;
import main.models.people.*;
import main.models.resources.*;
import main.models.resources.natural.*;
import main.models.resources.refined.*;
import main.models.tech.eras.*;
import main.utilities.*;
import main.utilities.builders.*;

import java.util.*;
import java.util.concurrent.*;

public class Archive {

    private ArrayList<GameObject> archive;
    private Map<String, GameObject> nameMapping;
    private static Archive instance;

    private Archive() {
        archive = new ArrayList<>();
        nameMapping = new HashMap<>();
        fillArchive();
    }

    public GameObject get(String key) {
        return nameMapping.get(key.toLowerCase()).clone();
    }

    public AbstractResource getRes(String key) {
        return (nameMapping.get(key) instanceof AbstractResource) ? (AbstractResource)nameMapping.get(key.toLowerCase()).clone() : null;
    }

    public ArrayList<AbstractResource> generateNewResources(String resourceName, int amt) {
        ArrayList<AbstractResource> output = new ArrayList<>();
        AbstractResource res = getRes(resourceName);
        if (res != null) {
            for (int i = 0; i < amt; i++) {
                output.add(res.clone());
            }
        }
        return output;
    }

    public AbstractItem getItem(String key) {
        return (nameMapping.get(key) instanceof AbstractItem) ? (AbstractItem)nameMapping.get(key.toLowerCase()).clone() : null;
    }

    public ArrayList<AbstractItem> generateNewItems(String resourceName, int amt) {
        ArrayList<AbstractItem> output = new ArrayList<>();
        AbstractItem res = getItem(resourceName);
        if (res != null) {
            for (int i = 0; i < amt; i++) {
                output.add(res.clone());
            }
        }
        return output;
    }

    public AbstractBuilding getBuilding(String key) {
        return (nameMapping.get(key) instanceof AbstractBuilding) ? (AbstractBuilding)nameMapping.get(key.toLowerCase()).clone() : null;
    }

    public ArrayList<AbstractBuilding> generateNewBuildings(String resourceName, int amt) {
        ArrayList<AbstractBuilding> output = new ArrayList<>();
        AbstractBuilding res = getBuilding(resourceName);
        if (res != null) {
            for (int i = 0; i < amt; i++) {
                output.add(res.clone());
            }
        }
        return output;
    }

    public AbstractAnimal getAnimal(String key) {
        return (nameMapping.get(key) instanceof AbstractAnimal) ? (AbstractAnimal)nameMapping.get(key.toLowerCase()).clone() : null;
    }

    public ArrayList<AbstractAnimal> generateNewAnimals(String resourceName, int amt) {
        ArrayList<AbstractAnimal> output = new ArrayList<>();
        AbstractAnimal res = getAnimal(resourceName);
        if (res != null) {
            for (int i = 0; i < amt; i++) {
                output.add(res.clone());
            }
        }
        return output;
    }

    public ArrayList<GameObject> copyOfArchive() {
        ArrayList<GameObject> objects = new ArrayList<>();
        for (GameObject o : archive) {
            objects.add(o.clone());
        }
        return objects;
    }

    public ArrayList<AbstractAnimal> animals() {
        ArrayList<AbstractAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
           if (o instanceof AbstractAnimal) {
               objects.add((AbstractAnimal) o.clone());
           }
        }
        return objects;
    }

    public ArrayList<AbstractDesertAnimal> desertAnimals() {
        ArrayList<AbstractDesertAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractDesertAnimal) {
                objects.add((AbstractDesertAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractJungleAnimal> jungleAnimals() {
        ArrayList<AbstractJungleAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractJungleAnimal) {
                objects.add((AbstractJungleAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractLandAnimal> landAnimals() {
        ArrayList<AbstractLandAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractLandAnimal) {
                objects.add((AbstractLandAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractBear> bears() {
        ArrayList<AbstractBear> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractBear) {
                objects.add((AbstractBear) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractMountainAnimal> mountainAnimals() {
        ArrayList<AbstractMountainAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractMountainAnimal) {
                objects.add((AbstractMountainAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractSeaAnimal> seaAnimals() {
        ArrayList<AbstractSeaAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractSeaAnimal) {
                objects.add((AbstractSeaAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractTundraAnimal> tundraAnimals() {
        ArrayList<AbstractTundraAnimal> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractTundraAnimal) {
                objects.add((AbstractTundraAnimal) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractBuilding> buildings() {
        ArrayList<AbstractBuilding> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractBuilding) {
                objects.add((AbstractBuilding) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractHouse> houses() {
        ArrayList<AbstractHouse> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractHouse) {
                objects.add((AbstractHouse) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractStorehouse> storehouses() {
        ArrayList<AbstractStorehouse> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractStorehouse) {
                objects.add((AbstractStorehouse) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractRefining> refineries() {
        ArrayList<AbstractRefining> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractRefining) {
                objects.add((AbstractRefining) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractFaithBuilding> churches() {
        ArrayList<AbstractFaithBuilding> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractFaithBuilding) {
                objects.add((AbstractFaithBuilding) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractDefenses> defenseBuildings() {
        ArrayList<AbstractDefenses> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractDefenses) {
                objects.add((AbstractDefenses) o.clone());
            }
        }
        return objects;
    }


    public ArrayList<AbstractItem> items() {
        ArrayList<AbstractItem> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractItem) {
                objects.add((AbstractItem) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractTool> tools() {
        ArrayList<AbstractTool> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractTool) {
                objects.add((AbstractTool) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractArtifact> artifacts() {
        ArrayList<AbstractArtifact> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractArtifact) {
                objects.add((AbstractArtifact) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<AbstractResource> resources() {
        ArrayList<AbstractResource> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof AbstractResource) {
                objects.add((AbstractResource) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<NaturalResource> natResources() {
        ArrayList<NaturalResource> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof NaturalResource) {
                objects.add((NaturalResource) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<RefinedResource> refResources() {
        ArrayList<RefinedResource> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof RefinedResource) {
                objects.add((RefinedResource) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<Era> eras() {
        ArrayList<Era> objects = new ArrayList<>();
        for (GameObject o : archive) {
            if (o instanceof Era) {
                objects.add((Era) o.clone());
            }
        }
        return objects;
    }

    public ArrayList<GameObject> getArchive() { return archive; }
    public static Archive getInstance() { return instance; }

    public static Survivor generateRandomSurvivor() {
        int randHP = ThreadLocalRandom.current().nextInt(10, 100);
        int randAge = randHP;
        randHP += ThreadLocalRandom.current().nextInt(-5, 5);
        int randAgility = ThreadLocalRandom.current().nextInt(1, 10);
        int randEngineer = ThreadLocalRandom.current().nextInt(1, 10);
        int randMagic = ThreadLocalRandom.current().nextInt(1, 10);
        int randDex = ThreadLocalRandom.current().nextInt(1, 10);
        int randStrength = ThreadLocalRandom.current().nextInt(1, 10);
        int randIntel = ThreadLocalRandom.current().nextInt(1, 10);
        boolean male = ThreadLocalRandom.current().nextBoolean();
        Gender gender;
        if (male) {
            gender = Gender.MALE;
        } else {
            gender = Gender.FEMALE;
        }
        return new SurvivorBuilder()
                .setName(GameStrings.getRandomName(true))
                .setHealthPoints(randHP)
                .setStrength(randStrength)
                .setIntelligence(randIntel)
                .setAge(randAge)
                .setAgility(randAgility)
                .setEngineering(randEngineer)
                .setGender(gender)
                .setRace(Game.getPlayerRace())
                .setMagic(randMagic)
                .setDexterity(randDex)
                .createSurvivor();
    }

    static {
        try { instance = new Archive(); }
        catch (Exception ex) { throw new RuntimeException("Failed to initialize Archive"); }
    }

    private void add(GameObject obj) {
        archive.add(obj);
        nameMapping.put(obj.getName().toLowerCase(), obj);
    }

    private void fillArchive() {
        add(new Ammunition());
        add(new Antibiotic());
        add(new Anvil());
        add(new Armadillo());
        add(new Armor());
        add(new Art());
        add(new AwesomeArtifact());
        add(new Axe());
        add(new Bandage());
        add(new BlackBear());
        add(new Blueprint());
        add(new Brick());
        add(new BronzeAge());
        add(new BrownBear());
        add(new Buffalo());
        add(new Camel());
        add(new Cat());
        add(new CaveBear());
        add(new Chicken());
        add(new Clay());
        add(new Coin());
        add(new Copper());
        add(new CopperIngot());
        add(new Cougar());
        add(new Cow());
        add(new CursedHome());
        add(new CursedStorehouse());
        add(new Ditch());
        add(new Dog());
        add(new Dolphin());
        add(new Duck());
        add(new ExplorationAge());
        add(new Fish());
        add(new FishingRod());
        add(new FishingSpear());
        add(new Flowers());
        add(new Forestdweller());
        add(new FutureAge());
        add(new Gems());
        add(new Glass());
        add(new Gold());
        add(new GoldenChurch());
        add(new GoldenStorehouse());
        add(new GoldenSword());
        add(new GoldenWatchtower());
        add(new GrizzlyBear());
        add(new Hammer());
        add(new Hoe());
        add(new HolyCrown());
        add(new Horse());
        add(new HuntingSpear());
        add(new IndustrialAge());
        add(new InformationAge());
        add(new Iron());
        add(new IronAge());
        add(new IronIngot());
        add(new Jewelery());
        add(new Jungleape());
        add(new Kiln());
        add(new KingsCoat());
        add(new LargeGoldHome());
        add(new LargeRockHome());
        add(new LargeStoneHome());
        add(new LargeWoodHome());
        add(new Lizard());
        add(new Lumber());
        add(new Mansion());
        add(new MassiveStorehouse());
        add(new MediumGoldHome());
        add(new MediumRockHome());
        add(new MediumStoneHome());
        add(new MediumWoodHome());
        add(new MoonShield());
        add(new Moose());
        add(new MountainGoat());
        add(new MountainHare());
        add(new Net());
        add(new Panda());
        add(new Penguin());
        add(new PestleAndMortar());
        add(new Pickaxe());
        add(new Pig());
        add(new Pizzly());
        add(new Platypus());
        add(new PodsRod());
        add(new PolarBear());
        add(new RabbitFoot());
        add(new Rock());
        add(new RockChurch());
        add(new RockStorehouse());
        add(new RockWatchtower());
        add(new RodCraftingTable());
        add(new Sand());
        add(new Scorpion());
        add(new Seal());
        add(new SeedBag());
        add(new Seeds());
        add(new Shark());
        add(new ShortStoneWall());
        add(new Sickle());
        add(new SlothBear());
        add(new SmallGoldHome());
        add(new SmallRockHome());
        add(new SmallStoneHome());
        add(new SmallWoodHome());
        add(new Spacegoo());
        add(new SpearCraftingTable());
        add(new Stone());
        add(new StoneAge());
        add(new StoneChurch());
        add(new StoneLeanTo());
        add(new StoneStorehouse());
        add(new StoneWatchtower());
        add(new SunSword());
        add(new Turkey());
        add(new Vaccine());
        add(new Weapon());
        add(new Whale());
        add(new Wildabeast());
        add(new Wood());
        add(new WoodLeanTo());
        add(new WoodSpikeWall());
        add(new WoodStoreHouse());
        add(new WoodenChurch());
        add(new WoodenWatchtower());
    }
}
