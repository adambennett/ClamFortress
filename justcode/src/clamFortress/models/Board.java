package clamFortress.models;

import clamFortress.models.animals.Animal;
import clamFortress.models.resources.natural.Flowers;
import clamFortress.models.resources.natural.Gems;
import clamFortress.models.tools.medical.HealingTool;

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
   static Integer healingItemsOnBoard;


   static Integer villageMana;

   public static Integer getNumberOfTreesOnBoard() {
      return numberOfTreesOnBoard;
   }

   public static void setNumberOfTreesOnBoard(Integer numberOfTreesOnBoard) {
      Board.numberOfTreesOnBoard = numberOfTreesOnBoard;
   }

   public static Integer getMineableStoneOnBoard() {
      return mineableStoneOnBoard;
   }

   public static void setMineableStoneOnBoard(Integer mineableStoneOnBoard) {
      Board.mineableStoneOnBoard = mineableStoneOnBoard;
   }

   public static Integer getHuntableAnimalsOnBoard() {
      return huntableAnimalsOnBoard;
   }

   public static void setHuntableAnimalsOnBoard(Integer huntableAnimalsOnBoard) {
      Board.huntableAnimalsOnBoard = huntableAnimalsOnBoard;
   }

   public static Integer getColectableClayOnBoard() {
      return colectableClayOnBoard;
   }

   public static void setColectableClayOnBoard(Integer colectableClayOnBoard) {
      Board.colectableClayOnBoard = colectableClayOnBoard;
   }

   public static Map<Flowers, Integer> getFlowersOnBoard() {
      return flowersOnBoard;
   }

   public static void setFlowersOnBoard(Map<Flowers, Integer> flowersOnBoard) {
      Board.flowersOnBoard = flowersOnBoard;
   }

   public static Integer getMineableCopperOreOnBoard() {
      return mineableCopperOreOnBoard;
   }

   public static void setMineableCopperOreOnBoard(Integer mineableCopperOreOnBoard) {
      Board.mineableCopperOreOnBoard = mineableCopperOreOnBoard;
   }

   public static Integer getMineableIronOreOnBoard() {
      return mineableIronOreOnBoard;
   }

   public static void setMineableIronOreOnBoard(Integer mineableIronOreOnBoard) {
      Board.mineableIronOreOnBoard = mineableIronOreOnBoard;
   }

   public static Map<Gems, Integer> getMineableGemsOnBoard() {
      return mineableGemsOnBoard;
   }

   public static void setMineableGemsOnBoard(Map<Gems, Integer> mineableGemsOnBoard) {
      Board.mineableGemsOnBoard = mineableGemsOnBoard;
   }

   public static Integer getFishableFishOnBoard() {
      return fishableFishOnBoard;
   }

   public static void setFishableFishOnBoard(Integer fishableFishOnBoard) {
      Board.fishableFishOnBoard = fishableFishOnBoard;
   }

   public static Map<Animal, Integer> getAnimalsInRegionOnBoard() {
      return animalsInRegionOnBoard;
   }

   public static void setAnimalsInRegionOnBoard(Map<Animal, Integer> animalsInRegionOnBoard) {
      Board.animalsInRegionOnBoard = animalsInRegionOnBoard;
   }

   public static Integer getHealingItemsOnBoard() {
      return healingItemsOnBoard;
   }

   public static void setHealingItemsOnBoard(Integer healingItemsOnBoard) {
      Board.healingItemsOnBoard = healingItemsOnBoard;
   }

   public static Integer getVillageMana() { return villageMana; }

   public static void setVillageMana(Integer villageMana) { Board.villageMana = villageMana; }

}
