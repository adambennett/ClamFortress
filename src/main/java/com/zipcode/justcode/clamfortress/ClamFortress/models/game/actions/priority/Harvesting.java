package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;
import org.hibernate.result.*;

import java.util.*;

public class Harvesting extends AbstractGameAction {

    public Harvesting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        int food = Database.getCurrentGame().getVillage().getFarm().harvest();
        if (food > 0) {
            Database.getCurrentGame().getVillage().incFood(food);
            OutputManager.addToBot("Harvested " + food + " food!");
        }
        this.isDone = true;
    }

    @Override
    public Harvesting clone() {
        return new Harvesting(this.amountToRun);
    }
}
