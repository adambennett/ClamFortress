package main.actions;

public abstract class AbstractGameAction {

    public boolean isDone;
    public int amount;

    public AbstractGameAction() {
        this.isDone = false;
    }

    public abstract void update();

}
