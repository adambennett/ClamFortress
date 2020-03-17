package main.actions;

public class Foraging extends AbstractGameAction {

    public Foraging() {
        this.actionType = ActionType.FORAGING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
