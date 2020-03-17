package main.actions;

public class Forging extends AbstractGameAction {

    public Forging() {
        this.actionType = ActionType.FORGING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
