package main.models.buildings.concrete.foodbuilding;

import main.models.buildings.abstracts.AbstractFoodBuilding;
import main.models.resources.natural.Wood;

public class Farmland extends AbstractFoodBuilding {

    public Farmland() {
        super("Farmland", "A good place to Plant Seeds", 100, new Wood());
    }

    @Override
    public AbstractFoodBuilding clone() {
        return new Farmland();
    }
}
