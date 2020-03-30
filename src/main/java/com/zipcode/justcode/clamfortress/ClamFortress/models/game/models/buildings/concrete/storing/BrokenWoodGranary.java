package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.storing;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class BrokenWoodGranary extends AbstractStorehouse {

    public BrokenWoodGranary() {
        super("Broken Wooden Granary", 0, 200, new Wood());
    }

    @Override
    public void onBuild() {
        int inc = this.getStorageCapacityIncrease();
        Database.getCurrentGame().getVillage().setFoodLimit((int) (Database.getCurrentGame().getVillage().getFoodLimit() + inc));
        OutputManager.addToBot("New Building " + this.getName() + " has been completed! Increased food cap by " + inc + ".");
    }

    @Override
    public BrokenWoodGranary clone() {
        return new BrokenWoodGranary();
    }
}
