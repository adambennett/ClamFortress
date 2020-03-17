package main.actions.priority;

import main.actions.*;
import main.models.nodes.City;

public class Raiding extends AbstractGameAction {

    private City city;

    public Raiding(City cityNode) {
        this.city = cityNode;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
