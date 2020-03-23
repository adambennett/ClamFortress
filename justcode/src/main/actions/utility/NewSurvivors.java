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

    private final boolean print;

    public NewSurvivors(boolean print) {
        super(1);
        this.print = print;
    }


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
        return new NewSurvivors(this.print);
    }

    public void addToVillage(int amt) {
        OutputManager.moveIn(amt);
        for (int i = 0; i < amt; i++) {
            Survivor newCitizen = Archive.generateRandomSurvivor(true);
            Game.getVillage().addToPopulation(newCitizen);
        }
    }
}
