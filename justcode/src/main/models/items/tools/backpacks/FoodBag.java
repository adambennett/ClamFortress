package main.models.items.tools.backpacks;

import main.models.*;

public class FoodBag extends AbstractBackpack {
    public FoodBag() {
        super("Food Bag", "Increases your food capacity by 100. Increases your inventory capacity by 10.");
    }

    @Override
    public void onObtain() {
        Game.getVillage().getInventory().setCapacity(Game.getVillage().getInventory().getCapacity() + 100);
        Game.getVillage().setFoodLimit(Game.getVillage().getFoodLimit() + 100);
    }

    @Override
    public FoodBag clone() {
        return new FoodBag();
    }
}
