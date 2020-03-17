package main.actions;

public class Recreating extends AbstractGameAction {

    public Recreating() {
        this.actionType = ActionType.RECREATING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
