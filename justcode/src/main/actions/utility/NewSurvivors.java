package main.actions.utility;

import main.actions.*;
import main.enums.*;
import main.models.*;
import main.models.managers.*;
import main.models.people.*;
import main.utilities.*;
import main.utilities.builders.*;

import java.util.concurrent.*;

public class NewSurvivors extends AbstractGameAction {

    @Override
    public void update() {
        int pop = Game.getVillage().getPopulation();
        int popCap = Game.getVillage().getPopCap();
        int diff = popCap - pop;
        if (pop < popCap && diff > 0) {
            int amtOfNewSurvivors = ThreadLocalRandom.current().nextInt(0, diff+1);
            int high = Game.getVillage().getHunger();
            if (high < 1) { high = 1; }
            int hungerRoll = ThreadLocalRandom.current().nextInt(0, high);
            amtOfNewSurvivors -= hungerRoll;
            if (amtOfNewSurvivors > 0) {
                addToVillage(amtOfNewSurvivors);
            }
        }
        this.isDone = true;
    }

    @Override
    public NewSurvivors clone() {
        return new NewSurvivors();
    }

    public void addToVillage(int amt) {
        for (int i = 0; i < amt; i++) {
            Survivor newCitizen = Archive.generateRandomSurvivor();
            Game.getVillage().addToPopulation(newCitizen);
            OutputManager.addToBot(newCitizen.getName() + " has moved into your village!");
        }
    }
}
