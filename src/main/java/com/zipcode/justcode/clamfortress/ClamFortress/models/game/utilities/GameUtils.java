package com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.disasters.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.miracles.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.encounters.plagues.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.artifacts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.consoleIO.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;

public class GameUtils {

    private static BiFunction<GameObject, Integer, Integer> mapper;

    static {
        mapper = (k, v) -> (v == null) ? 1 : v+1;
    }

    public static BiFunction<GameObject, Integer, Integer> getMapper() {
        return mapper;
    }

    public static BiFunction<GameObject, Integer, Integer> getMapper(int amt) {
        return (k, v) -> (v == null) ? 1 : v+amt;
    }

    public static BiFunction<AbstractNode, Integer, Integer> getNodeMapper() {
        return (k, v) -> (v == null) ? 1 : v+1;
    }

    public static BiFunction<AbstractNode, Integer, Integer> getNodeMapper(int amt) {
        return (k, v) -> (v == null) ? 1 : v+amt;
    }

    public static Map<AbstractResource, Integer> mapToMap(final Map<AbstractResource, Integer> map1, final Map<AbstractResource, Integer> map2) {
        return map2.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v -> (map1.get(v.getKey())==null) ? v.getValue() : v.getValue() + map1.get(v.getKey())));
    }

    public static void whenObtainingAnyItem(GameObject obtained) {
        int maxHPGain = obtained.modifyMaxHPOnPickup();
        /*if (maxHPGain > 0 && Database.getCurrentGame().getVillage().getPopulation().size() > 0) {
            Survivor s = Database.getCurrentGame().getVillage().getPopulation().get(ThreadLocalRandom.current().nextInt(Database.getCurrentGame().getVillage().getPopulation().size()));
            s.setMaxHp(s.getMaxHp() + maxHPGain);
            Database.getCurrentGame().getVillage().setHealth(Database.getCurrentGame().getVillage().getHealth() + maxHPGain);
        }*/
        StatTracker.setHighRes(Database.getCurrentGame().getVillage().getAllResources().size());
        StatTracker.setHighBuild(Database.getCurrentGame().getVillage().getBuildings().size());
    }

    public static String getNewRaidCity() {
        if (Database.getCurrentGame().gameManager.getRaidable().size() > 0) {
            List<City> cities = Database.getCurrentGame().gameManager.getRaidable();
            ArrayList<City> otherCities = new ArrayList<>();
            if (cities.size() > 0) {
                for (City c : cities) {
                    if (Database.getCurrentGame().gameManager.getRaidingCity() == null) {
                        if (!c.getDefeated()) {
                            otherCities.add(c);
                        }
                    } else {
                        if (!c.equals(Database.getCurrentGame().gameManager.getRaidingCity()) && !c.getDefeated()) {
                            otherCities.add(c);
                        }
                    }
                }

                if (otherCities.size() > 0) {
                    String oldName = "";
                    if (Database.getCurrentGame().gameManager.getRaidingCity() != null) {
                        oldName = Database.getCurrentGame().gameManager.getRaidingCity().cityName();
                    }
                    Database.getCurrentGame().gameManager.setRaidingCity(otherCities.get(ThreadLocalRandom.current().nextInt(otherCities.size())));
                    City ref = Database.getCurrentGame().gameManager.getRaidingCity();
                    int amtOfResources = 0;
                    for (Map.Entry<AbstractResource, Integer> i : Database.getCurrentGame().gameManager.getRaidingCity().getResources().entrySet()) {
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
                    return output;
                }
            }
        }
        return "";
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
            Database.getCurrentGame().getVillage().addResource((AbstractResource) obj, amt);
        } else if (obj instanceof Era) {
            TechTree.moveToEra((Era) obj, true);
        } /*else if (obj instanceof AbstractMiracle) {
            Database.getCurrentGame().getVillage().addMiracle((AbstractMiracle) obj);
        }  if (obj instanceof AbstractPlague) {
            Database.getCurrentGame().getVillage().addPlague((AbstractPlague) obj);
        } else if (obj instanceof AbstractDisaster) {
            Database.getCurrentGame().getVillage().addDisaster((AbstractDisaster) obj);
        }*/
    }

    public static void obtainArtifact(AbstractArtifact artifact) {
        if (Database.getCurrentGame().getVillage().getInventory().addItem(artifact)) {
            if (StringHelpers.startsWithVowel(artifact.getName())) {
                OutputManager.addToBot("Found an " + artifact.getName() + "!");
            } else {
                OutputManager.addToBot("Found a " + artifact.getName() + "!");
            }
        }
    }

    public static void obtainItem(AbstractItem item) {
        if (Database.getCurrentGame().getVillage().getInventory().addItem(item)) {
            OutputManager.addToBot("Found " + item.getName() + "!");
        }
    }

    public static Boolean obtainBuilding(AbstractBuilding building) {
        if (building.canObtain() && Database.getCurrentGame().getVillage().addBuilding(building)) {
            building.onBuild();
            building.onObtain();
            whenObtainingAnyItem(building);
            Database.getCurrentGame().gameManager.gainExperience();
            return true;
        }
        return false;
    }

   /* public static void discoverNode(AbstractNode space) {
        Database.getCurrentGame().getGameBoard().addGridSpace(space);
    }*/

    public static void advanceEra() {
        if (TechTree.getCurrentEra().hasNext() && TechTree.getCurrentEra().getNext().canObtain()) {
            TechTree.incEra();
            TechTree.getCurrentEra().onObtain();
            for (GameObject obj : Database.getCurrentGame().getModifierObjects()) {
                obj.onAdvanceEra(TechTree.getCurrentEra());
            }
            whenObtainingAnyItem(TechTree.getCurrentEra());
            OutputManager.addToBot("Advanced to " + TechTree.getCurrentEra().toString());
        }
    }

    // ONLY FOR DEV CONSOLE
    public static void devConsoleObtainObject(GameObject obj, int amt, AbstractConsole from, boolean triggerExtras) {
        if (obj instanceof Coin) {
            Database.getCurrentGame().getVillage().incCoins(amt);
        }
        if (obj instanceof AbstractItem) {
            AbstractItem item = (AbstractItem) obj;
            for (int i = 0; i < amt; i++) {
                Database.getCurrentGame().getVillage().getInventory().addItem(item.clone());
            }
        } else if (obj instanceof AbstractBuilding) {
            AbstractBuilding b = (AbstractBuilding) obj;
            for (int i = 0; i < amt; i++) {
                Database.getCurrentGame().getVillage().getBuildings().compute(b, (k, v) -> (v==null) ? 1 : v + 1);
                b.onBuild();
                if (triggerExtras) {
                    for (GameObject objB : Database.getCurrentGame().getModifierObjects()) {
                        objB.onNewBuilding(b);
                    }
                }
            }
        } else if (obj instanceof AbstractResource) {
            if (Database.getCurrentGame().getVillage().getAllResources().size() + amt > Database.getCurrentGame().getVillage().getResourceLimit()) {
                Database.getCurrentGame().getVillage().setResourceLimit(Database.getCurrentGame().getVillage().getAllResources().size() + amt);
            }
            Database.getCurrentGame().getVillage().addResource((AbstractResource) obj, amt);
        } else if (obj instanceof Era) {
            TechTree.moveToEra((Era)obj, true);
        } /*else if (obj instanceof AbstractMiracle) {
            Database.getCurrentGame().getVillage().addMiracle((AbstractMiracle) obj);
        }  if (obj instanceof AbstractPlague) {
            Database.getCurrentGame().getVillage().addPlague((AbstractPlague) obj);
        } else if (obj instanceof AbstractDisaster) {
            Database.getCurrentGame().getVillage().addDisaster((AbstractDisaster) obj);
        }*/

        StringHelpers.reloadStrings();
        if (from instanceof TurnMenu) {
            from.initializeCommands();
        }
    }
}
