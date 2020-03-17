package main.actions;

public class Smithing extends AbstractGameAction {

    public Smithing() {
        this.actionType = ActionType.SMITHING;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
