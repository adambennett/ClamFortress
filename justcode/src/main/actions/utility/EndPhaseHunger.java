package main.actions.utility;

import main.actions.*;
import main.models.*;
import main.models.beings.*;
import main.models.managers.*;

import java.util.*;

public class EndPhaseHunger extends AbstractGameAction {

    public EndPhaseHunger() {
        super(1);
    }

    @Override
    public void update() {
        int numHungry = Game.getVillage().feedAllVillagers();
        if (Game.getVillage().getFood() > 0) {
            Game.getVillage().setFamine(Game.getVillage().getFamine() - Game.getVillage().getFood());
        }
        ArrayList<String> surviorsWhoLeft = new ArrayList<>();
        for (int i = 0; i < Game.getVillage().getFamine(); i++) {
            if (Game.getVillage().getPopulation() > 0) {
                Survivor s = Game.getVillage().removeRandomSurvivor();
                surviorsWhoLeft.add(s.getName());
            }
        }
        if (surviorsWhoLeft.size() > 0) {
            OutputManager.famineLoss(surviorsWhoLeft.size());
        }
        double newFamine = numHungry / 4.0;
        if (numHungry > 0 && (int)newFamine < 0) {
            newFamine = 1.0;
        }
        Game.getVillage().setFamine((int) newFamine);
        Game.getVillage().setHunger(numHungry);
        this.isDone = true;
    }

    @Override
    public EndPhaseHunger clone() {
        return new EndPhaseHunger();
    }

}
