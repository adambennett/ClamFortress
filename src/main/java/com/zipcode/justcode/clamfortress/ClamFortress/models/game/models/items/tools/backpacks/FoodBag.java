package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.backpacks;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class FoodBag extends AbstractBackpack {
    public FoodBag() {
        super("Food Bag", "Increases your food capacity by 100. Increases your inventory capacity by 10.");
    }

    @Override
    public void onObtain() {
        Database.getCurrentGame().getVillage().getInventory().setCapacity(Database.getCurrentGame().getVillage().getInventory().getCapacity() + 100);
        Database.getCurrentGame().getVillage().setFoodLimit(Database.getCurrentGame().getVillage().getFoodLimit() + 100);
    }

    @Override
    public FoodBag clone() {
        return new FoodBag();
    }
}
