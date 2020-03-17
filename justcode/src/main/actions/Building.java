package main.actions;

public class Building extends AbstractGameAction {

    public Building() {
        this.actionType = ActionType.BUILDING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
