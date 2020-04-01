package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.utility;



import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.beings.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

import java.util.*;

public class EndPhaseHunger extends AbstractGameAction {

    public EndPhaseHunger() {
        super(1);
    }

    @Override
    public void update() {
        /*int numHungry = Database.getCurrentGame().getVillage().feedAllVillagers();
        if (Database.getCurrentGame().getVillage().getFood() > 0) {
            Database.getCurrentGame().getVillage().setFamine(Database.getCurrentGame().getVillage().getFamine() - Database.getCurrentGame().getVillage().getFood());
        }
        ArrayList<String> surviorsWhoLeft = new ArrayList<>();
        for (int i = 0; i < Database.getCurrentGame().getVillage().getFamine(); i++) {
            if (Database.getCurrentGame().getVillage().getPopulation().size() > 0) {
                Survivor s = Database.getCurrentGame().getVillage().removeRandomSurvivor();
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
        Database.getCurrentGame().getVillage().setFamine((int) newFamine);
        Database.getCurrentGame().getVillage().setHunger(numHungry);*/
        this.isDone = true;
    }

    @Override
    public EndPhaseHunger clone() {
        return new EndPhaseHunger();
    }

}
