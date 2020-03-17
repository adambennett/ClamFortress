package main.actions;

public abstract class AbstractGameAction implements Cloneable {

    public boolean isDone;
    public int amount;

    public AbstractGameAction() {
        this.isDone = false;
    }

    public abstract void update();

    @Override
    public abstract AbstractGameAction clone();

}
