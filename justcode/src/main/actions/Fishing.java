package main.actions;

public class Fishing extends AbstractGameAction {

    public Fishing() {
        this.actionType = ActionType.FISHING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
