package clamFortress.models;

import clamFortress.models.animals.Animal;
import clamFortress.models.resources.*;
import clamFortress.models.resources.natural.Flowers;
import clamFortress.models.resources.natural.Gems;
import clamFortress.models.tools.medical.*;

import java.util.*;

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
   static Map<HealingTool, Integer> healingItemsOnBoard;

   public static ArrayList<NaturalResource> mineables;
   public static ArrayList<NaturalResource> collectables;
   public static ArrayList<NaturalResource> refinables;


}
