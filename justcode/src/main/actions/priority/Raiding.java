package main.actions.priority;

import main.actions.*;
import main.models.nodes.City;

public class Raiding extends AbstractGameAction {

    private final City city;

    public Raiding(City cityNode, int amtToRun) {
        super(amtToRun);
        this.city = cityNode;
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Raiding clone() {
        return new Raiding(this.city, this.amountToRun);
    }
}
