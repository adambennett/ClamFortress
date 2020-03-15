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
  private  Integer mineableGemsOnBoard;
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

   public Integer getMineableGemsOnBoard() {
      return mineableGemsOnBoard;
   }

   public void setMineableGemsOnBoard(Integer mineableGemsOnBoard) {
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

   public void reduceTreesOnBoard(Integer amountToCutDown){
      this.numberOfTreesOnBoard -= amountToCutDown;
       if(this.numberOfTreesOnBoard < 0){
           this.numberOfTreesOnBoard =0;
       }
   }

   public void reduceStoneOnBoard(Integer amountToMine){
      this.mineableStoneOnBoard -= amountToMine;
      if(this.mineableStoneOnBoard < 0){
          this.mineableStoneOnBoard = 0;
      }
   }

    public void reduceCopperOreOnBoard(Integer amountToMine){
        this.mineableCopperOreOnBoard -= amountToMine;
        if(this.mineableCopperOreOnBoard < 0){
            this.mineableCopperOreOnBoard = 0;
        }
    }

    public void reduceIronOreOnBoard(Integer amountToMine){
      this.mineableIronOreOnBoard -= amountToMine;
        if(this.mineableIronOreOnBoard < 0){
            this.mineableIronOreOnBoard = 0;
        }
    }

    public void reduceGemsOnBoard(Integer amountToMine){
        this.mineableGemsOnBoard -= amountToMine;
        if(this.mineableGemsOnBoard < 0){
            this.mineableGemsOnBoard = 0;
        }
    }

    public void reduceFishOnBoard(Integer amountToMine){
        this.fishableFishOnBoard -= amountToMine;
        if(this.fishableFishOnBoard < 0){
            this.fishableFishOnBoard = 0;
        }
    }

    public void reduceHuntableAnimals(Integer amountToHunt){
      this.huntableAnimalsOnBoard -= amountToHunt;
      if(this.huntableAnimalsOnBoard < 0){
          huntableAnimalsOnBoard = 0;
      }
    }

    public void reduceHealingItemsOnBoard(Integer amountToUse){
      this.healingItemsOnBoard -= amountToUse;
      if(this.healingItemsOnBoard < 0){
          healingItemsOnBoard = 0;
      }
    }
}
