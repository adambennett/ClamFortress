package main.actions;

public class StonePicking extends AbstractGameAction {


    public StonePicking() {
        this.actionType = ActionType.MASONRY;
    }

    @Override
    public void update() {
        Integer stoneToReturn = 15;
        this.isDone = true;
    }
}
