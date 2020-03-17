package main.actions;

public class Sailing extends AbstractGameAction {

    public Sailing() {
        this.actionType = ActionType.SAILING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
