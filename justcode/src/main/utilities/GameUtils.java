package main.utilities;

import main.interfaces.*;
import main.models.*;
import main.models.buildings.abstracts.*;
import main.models.items.*;
import main.models.items.artifacts.*;
import main.models.managers.*;
import main.models.nodes.*;
import main.models.people.*;
import main.models.resources.*;
import main.models.tech.*;
import main.models.tech.eras.*;
import main.utilities.stringUtils.*;

import java.util.*;
import java.util.concurrent.*;

public class GameUtils {


    public static void whenObtainingAnyItem(GameObject obtained) {
        int maxHPGain = obtained.modifyMaxHPOnPickup();
        if (maxHPGain > 0 && Game.getVillage().getPopulation() > 0) {
            Survivor s = Game.getVillage().getSurvivors().get(ThreadLocalRandom.current().nextInt(Game.getVillage().getSurvivors().size()));
            s.setMaxHp(s.getMaxHp() + maxHPGain);
            Game.getVillage().setHealth(Game.getVillage().getHealth() + maxHPGain);
        }
    }

    public static void getNewRaidCity() {
        if (GameManager.getInstance().getRaidable().size() > 0) {
            ArrayList<City> cities = GameManager.getInstance().getRaidable();
            ArrayList<City> otherCities = new ArrayList<>();
            if (cities.size() > 0) {
                for (City c : cities) {
                    if (GameManager.getInstance().getRaidingCity() == null) {
                        if (!c.getDefeated()) {
                            otherCities.add(c);
                        }
                    } else {
                        if (!c.equals(GameManager.getInstance().getRaidingCity()) && !c.getDefeated()) {
                            otherCities.add(c);
                        }
                    }
                }

                if (otherCities.size() > 0) {
                    String oldName = "";
                    if (GameManager.getInstance().getRaidingCity() != null) {
                        oldName = GameManager.getInstance().getRaidingCity().cityName();
                    }
                    GameManager.getInstance().setRaidingCity(otherCities.get(ThreadLocalRandom.current().nextInt(otherCities.size())));
                    City ref = GameManager.getInstance().getRaidingCity();
                    int amtOfResources = 0;
                    for (Map.Entry<AbstractResource, Integer> i : GameManager.getInstance().getRaidingCity().getResources().entrySet()) {
                        amtOfResources += i.getValue();
                    }
                    boolean hasItem = ref.hasItem();
                    boolean hasArt = ref.hasArtifact();
                    String firstString = "";
                    if (oldName.equals("")) {
                        firstString = "Raiding City has been switched to " + ref.cityName();
                    } else {
                        firstString = "Raiding City has been switched from " + oldName + " to " + ref.cityName();
                    }
                    String output = firstString;
                    output += "\nCity Stats\n---------- \nDefense: " + ref.getCityDefense();
                    output += "\nHealth: " + ref.getHp() + " / " + ref.getMaxHP();
                    output += "\nPopulation: " + ref.getCityResidence().size();
                    output += "\nResources: " + amtOfResources;
                    if (hasArt) {
                        output += "\nArtifact: " + ref.getArtifact().getName();
                    } else if (hasItem) {
                        output += "\nItem: " + ref.getItem().getName();
                    }
                    ConsoleServices.println(output);
                }
            }
        }
    }

    public static void obtainGameObject(GameObject obj) {
        obtainGameObject(obj, 1);
    }

    public static void obtainGameObject(GameObject obj, int amt) {
        if (obj instanceof AbstractArtifact) {
            for (int i = 0; i < amt; i++) {
                obtainArtifact((AbstractArtifact) obj);
            }
        } else if (obj instanceof AbstractItem) {
            for (int i = 0; i < amt; i++) {
                obtainItem((AbstractItem) obj.clone());
            }
        } else if (obj instanceof AbstractBuilding) {
            for (int i = 0; i < amt; i++) {
                obtainBuilding((AbstractBuilding) obj.clone());
            }
        } else if (obj instanceof AbstractResource) {
            Game.getVillage().addResource((AbstractResource) obj, amt);
        }
    }

    public static void obtainArtifact(AbstractArtifact artifact) {
        if (Game.getVillage().getInventory().addItem(artifact)) {
            if (StringHelpers.startsWithVowel(artifact.getName())) {
                OutputManager.addToBot("Found an " + artifact.getName() + "!");
            } else {
                OutputManager.addToBot("Found a " + artifact.getName() + "!");
            }
        }
    }

    public static void obtainItem(AbstractItem item) {
        if (Game.getVillage().getInventory().addItem(item)) {
            OutputManager.addToBot("Found " + item.getName() + "!");
        }
    }

    public static Boolean obtainBuilding(AbstractBuilding building) {
        if (building.canObtain() && Game.getVillage().addBuilding(building)) {
            building.onBuild();
            building.onObtain();
            whenObtainingAnyItem(building);
            GameManager.getInstance().gainExperience();
            return true;
        }
        return false;
    }

    public static void discoverNode(AbstractNode space) {
        Game.getGameBoard().addGridSpace(space);
    }

    public static void advanceEra() {
        if (TechTree.getCurrentEra().hasNext() && TechTree.getCurrentEra().getNext().canObtain()) {
            TechTree.incEra();
            TechTree.getCurrentEra().onObtain();
            whenObtainingAnyItem(TechTree.getCurrentEra());
            OutputManager.addToBot("Advanced to " + TechTree.getCurrentEra().toString());
        }
    }

    // ONLY FOR DEV CONSOLE
    public static void devConsoleObtainObject(GameObject obj, int amt) {
        if (obj instanceof AbstractItem) {
            AbstractItem item = (AbstractItem) obj;
            for (int i = 0; i < amt; i++) {
                Game.getVillage().getInventory().getItems().add(item);
                item.onObtain();
                GameUtils.whenObtainingAnyItem(item);
                if (item instanceof Golden) {
                    Game.getVillage().setCoins(Game.getVillage().getCoins() + ((Golden) item).getGoldAmt());
                    OutputManager.addToBot("Received " + ((Golden) item).getGoldAmt() + " Coins upon pickup of Golden item! (" + item.getName() + ")");
                }

                if (item instanceof Cursed) {
                    ((Cursed) item).runCurse();
                    OutputManager.addToBot("You have been Cursed upon the pickup of a cursed item! (" + item.getName() + ")");
                }
            }
        } else if (obj instanceof AbstractBuilding) {
            AbstractBuilding b = (AbstractBuilding) obj;
            for (int i = 0; i < amt; i++) {
                Game.getVillage().getBuildings().add(b);
                for (GameObject objB : Game.getModifierObjects()) {
                    objB.onNewBuilding(b);
                }
            }
        } else if (obj instanceof AbstractResource) {
            if (Game.getVillage().getAllResources().size() + amt > Game.getVillage().getResourceLimit()) {
                Game.getVillage().setResourceLimit(Game.getVillage().getAllResources().size() + amt);
            }
            Game.getVillage().addResource((AbstractResource) obj, amt);
        } else if (obj instanceof Era) {
            TechTree.moveToEra((Era)obj, true);
        }
    }
}
