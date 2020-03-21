package main.actions.priority;

import main.actions.*;
import main.models.*;
import main.models.nodes.City;

public class Raiding extends AbstractGameAction {

    private final City city;

    public Raiding(City cityNode, int amtToRun) {
        super(amtToRun);
        this.city = cityNode;
    }

    @Override
    public void update() {
        if (this.city != null && !this.city.getDefeated()) {
            Game.getVillage().takeDamage(city.dealDamage());
            city.takeDamage(Game.getVillage().dealDamage());
        }
        this.isDone = true;
    }

    @Override
    public Raiding clone() {
        return new Raiding(this.city, this.amountToRun);
    }
}
