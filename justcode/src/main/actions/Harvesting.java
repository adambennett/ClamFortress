package main.actions;

public class Harvesting extends AbstractGameAction {

    public Harvesting() {
        this.actionType = ActionType.HARVESTING;
    }

    @Override
    public void update() {
        this.isDone = true;

    }


}
