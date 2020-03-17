package main.actions.priority;

import main.actions.*;

import java.util.*;

public class Healing extends AbstractGameAction {


    @Override
    public void update() {
        this.isDone = true;
    }

    @Override
    public Healing clone() {
        return new Healing();
    }
}
