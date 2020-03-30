package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Planting extends AbstractGameAction {

    public Planting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        if (Database.getCurrentGame() != null) {
            Village vil = Database.getCurrentGame().getVillage();
            if (vil != null && vil.getResource("seeds") != null) {
                int seeds = vil.getResource("seeds");
                if (seeds > 0) {
                    vil.removeResource("seeds", 1);
                    vil.getFarm().addSeeds(new Seeds(), 1);
                    OutputManager.addToBot("Planted a seed!");
                }
            }
        }
        this.isDone = true;
    }

    @Override
    public Planting clone() {
        return new Planting(this.amountToRun);
    }

}