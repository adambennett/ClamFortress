package main.actions.priority.food.alien;

import main.actions.*;

public class Analyzing extends AbstractGameAction {



    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Analyzing clone() {
        return new Analyzing();
    }
}
