package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.utility;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.concurrent.*;

public class NewSurvivors extends AbstractGameAction {

    private final boolean print;

    public NewSurvivors(boolean print) {
        super(1);
        this.print = print;
    }


    @Override
    public void update() {
        int pop = Database.getCurrentGame().getVillage().getPopulation().size();
        int popCap = Database.getCurrentGame().getVillage().getPopCap();
        int diff = popCap - pop;
        if (pop < popCap && diff > 0) {
            int amtOfNewSurvivors = ThreadLocalRandom.current().nextInt(0, diff+1);
            int high = Database.getCurrentGame().getVillage().getHunger();
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
            Database.getCurrentGame().getVillage().addToPopulation(newCitizen);
        }
    }
}
