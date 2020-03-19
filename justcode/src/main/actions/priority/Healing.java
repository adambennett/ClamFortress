package main.actions.priority;

import main.actions.*;

import java.util.*;

public class Healing extends AbstractGameAction {


    public Healing(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Healing clone() {
        return new Healing(this.amountToRun);
    }
}
