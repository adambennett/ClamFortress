package main.actions.priority;

import main.actions.*;

public class Masonry extends AbstractGameAction {

    @Override
    public void update() {
        this.isDone = true;

    }

    @Override
    public Masonry clone() {
        return new Masonry();
    }
}
