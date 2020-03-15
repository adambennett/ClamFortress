package clamFortress.models;

import clamFortress.encounters.alien.*;
import clamFortress.models.animals.Animal;
import clamFortress.models.resources.*;
import clamFortress.models.resources.natural.Flowers;
import clamFortress.models.resources.natural.Gems;

import clamFortress.models.tools.medical.HealingTool;

import java.util.*;

public class Board {

  private  Integer numberOfTreesOnBoard;
  private  Integer mineableStoneOnBoard;
  private  Integer huntableAnimalsOnBoard;
  private  Integer colectableClayOnBoard;
  private  Map<Flowers,Integer> flowersOnBoard;
  private  Integer mineableCopperOreOnBoard;
  private  Integer mineableIronOreOnBoard;
  private  Map<Gems,Integer> mineableGemsOnBoard;
  private  Integer fishableFishOnBoard;
  private  Map<Animal,Integer> animalsInRegionOnBoard;
  private  Integer healingItemsOnBoard;
  private ArrayList<AbstractAliens> aliensOnBoard;

  public Board() {
      aliensOnBoard = new ArrayList<>();
  }

  public void addAlienEncounter(AbstractAliens a) {
      aliensOnBoard.add(a);
  }


   public  Integer getNumberOfTreesOnBoard() {
       return numberOfTreesOnBoard;
   }

   public  void setNumberOfTreesOnBoard(Integer numberOfTreesOnBoard) {
      this.numberOfTreesOnBoard = numberOfTreesOnBoard;
   }

   public Integer getMineableStoneOnBoard() {
      return mineableStoneOnBoard;
   }

   public void setMineableStoneOnBoard(Integer mineableStoneOnBoard) {
      this.mineableStoneOnBoard = mineableStoneOnBoard;
   }

   public Integer getHuntableAnimalsOnBoard() {
      return huntableAnimalsOnBoard;
   }

   public void setHuntableAnimalsOnBoard(Integer huntableAnimalsOnBoard) {
      this.huntableAnimalsOnBoard = huntableAnimalsOnBoard;
   }

   public Integer getColectableClayOnBoard() {
      return colectableClayOnBoard;
   }

   public void setColectableClayOnBoard(Integer colectableClayOnBoard) {
      this.colectableClayOnBoard = colectableClayOnBoard;
   }

   public Map<Flowers, Integer> getFlowersOnBoard() {
      return flowersOnBoard;
   }

   public void setFlowersOnBoard(Map<Flowers, Integer> flowersOnBoard) {
      this.flowersOnBoard = flowersOnBoard;
   }

   public Integer getMineableCopperOreOnBoard() {
      return mineableCopperOreOnBoard;
   }

   public void setMineableCopperOreOnBoard(Integer mineableCopperOreOnBoard) {
      this.mineableCopperOreOnBoard = mineableCopperOreOnBoard;
   }

   public Integer getMineableIronOreOnBoard() {
      return mineableIronOreOnBoard;
   }

   public void setMineableIronOreOnBoard(Integer mineableIronOreOnBoard) {
      this.mineableIronOreOnBoard = mineableIronOreOnBoard;
   }

   public Map<Gems, Integer> getMineableGemsOnBoard() {
      return mineableGemsOnBoard;
   }

   public void setMineableGemsOnBoard(Map<Gems, Integer> mineableGemsOnBoard) {
      this.mineableGemsOnBoard = mineableGemsOnBoard;
   }

   public Integer getFishableFishOnBoard() {
      return fishableFishOnBoard;
   }

   public void setFishableFishOnBoard(Integer fishableFishOnBoard) {
      this.fishableFishOnBoard = fishableFishOnBoard;
   }

   public Map<Animal, Integer> getAnimalsInRegionOnBoard() {
      return animalsInRegionOnBoard;
   }

   public void setAnimalsInRegionOnBoard(Map<Animal, Integer> animalsInRegionOnBoard) {
      this.animalsInRegionOnBoard = animalsInRegionOnBoard;
   }

   public Integer getHealingItemsOnBoard() {
       return healingItemsOnBoard;
   }

   public void setHealingItemsOnBoard(Integer healingItemsOnBoard) {
      this.healingItemsOnBoard = healingItemsOnBoard;
   }
}
