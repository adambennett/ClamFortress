package main.actions;

public class Hunting extends AbstractGameAction {

    public Hunting() {
        this.actionType = ActionType.HUNTING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }
}
