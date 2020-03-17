package main.actions;

public class Smelting extends AbstractGameAction {

    public Smelting() {
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        this.isDone = true;
    }
}
