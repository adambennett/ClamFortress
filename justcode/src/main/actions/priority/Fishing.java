package main.actions.priority;

import main.actions.*;
import main.models.Game;
import main.models.artifacts.PodsRod;

import java.util.Random;

public class Fishing extends AbstractGameAction {

    private Random random = new Random();
    private PodsRod rod = new PodsRod();

    @Override
    public void update() {
        int fishOnBoard = Game.getGameBoard().getFish().size();
        if (fishOnBoard > 0){
            int rando = random.nextInt(fishOnBoard);
            Integer foodToReturn = Game.getGameBoard().getFish().get(rando).getAmountOfFoodOnHunt();
            Game.getGameBoard().getFish().remove(rando);
                if(Game.getVillage().getInventory().containsArtifact(rod)){
                foodToReturn *= rod.modifyFoodOnFishing();

                }
            Game.getVillage().incFood(foodToReturn);
        } else{
            Game.getVillage().incFood(1);
        }


        this.isDone = true;
    }
}
