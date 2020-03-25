package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.food;

public class PlaceholderFood extends AbstractFood {

    public PlaceholderFood(Integer healing) {
        super(healing, "PlaceholderFood", "Placeholder Description");
    }

    @Override
    public PlaceholderFood clone() {
        return new PlaceholderFood(this.getHealing());
    }
}
