package main.models.resources.refined.food;

import main.models.resources.*;

public class PlaceholderFood extends AbstractFood {

    public PlaceholderFood(Integer healing) {
        super(healing, "PlaceholderFood", "Placeholder Description");
    }

    @Override
    public PlaceholderFood clone() {
        return new PlaceholderFood(this.getHealing());
    }
}
