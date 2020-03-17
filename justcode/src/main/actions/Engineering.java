package main.actions;

public class Engineering extends AbstractGameAction {

    public Engineering() {
        this.actionType = ActionType.ENGINEERING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
