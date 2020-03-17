package main.actions;

public class Planting extends AbstractGameAction {

    public Planting() {
        this.actionType = ActionType.PLANTING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
