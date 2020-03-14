package clamFortress.models;

import clamFortress.actions.Healing;
import clamFortress.models.animals.Animal;
import clamFortress.models.resources.natural.Flowers;
import clamFortress.models.resources.natural.Gems;
import clamFortress.models.tools.medical.healingTool;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Integer numberOfTrees;
    Integer mineableStone;
    Integer huntableAnimals;
    Integer colectableClay;
    Map<Flowers,Integer> flowers;
    Integer mineableCopperOre;
    Integer mineableIronOre;
    Map<Gems,Integer> mineableGems;
    Integer fishableFish;
    Map<Animal,Integer> animalsInRegion;
    Map<healingTool, Integer> healingItems;
}
