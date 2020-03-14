package clamFortress.models;

import clamFortress.actions.Healing;
import clamFortress.models.animals.Animal;
import clamFortress.models.resources.natural.Flowers;
import clamFortress.models.resources.natural.Gems;
import clamFortress.models.tools.medical.healingTool;

import java.util.HashMap;
import java.util.Map;

public class Board {
   static Integer numberOfTreesOnBoard;
   static Integer mineableStoneOnBoard;
   static Integer huntableAnimalsOnBoard;
   static Integer colectableClayOnBoard;
   static Map<Flowers,Integer> flowersOnBoard;
   static Integer mineableCopperOreOnBoard;
   static Integer mineableIronOreOnBoard;
   static Map<Gems,Integer> mineableGemsOnBoard;
   static Integer fishableFishOnBoard;
   static Map<Animal,Integer> animalsInRegionOnBoard;
   static Map<healingTool, Integer> healingItemsOnBoard;
}
