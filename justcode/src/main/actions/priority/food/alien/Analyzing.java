package main.actions.priority.food.alien;

import main.actions.*;

public class Analyzing extends AbstractGameAction {


    public Analyzing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Analyzing clone() {
        return new Analyzing(this.amountToRun);
    }
}
