package main.actions.priority.food.dwarf;

import main.actions.*;

public class Scavenging extends AbstractGameAction {
    public Scavenging(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Scavenging clone() {
        return new Scavenging(this.amountToRun);
    }
}
