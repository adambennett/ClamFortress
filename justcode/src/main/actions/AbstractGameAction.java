package main.actions;

public abstract class AbstractGameAction {

    public ActionType actionType;
    public boolean isDone;
    public int amount;

    public AbstractGameAction() {
        this.isDone = false;
    }

    protected void addToBot(AbstractGameAction action) {

    }

    protected void addToTop(AbstractGameAction action) {

    }

    public abstract void update();

    public static enum ActionType {
        BUILDING,
        DEFENDING,
        ENGINEERING,
        FISHING,
        FORAGING,
        FORGING,
        HARVESTING,
        HEALING,
        HUNTING,
        MASONRY,
        PLANTING,
        PRAYING,
        RECREATING,
        RAIDING,
        SAILING,
        SCOUTING,
        SMITHING,
        TRADING,
        NEW_SURVIVORS,
        WOODCUTTING;

        private ActionType() {

        }
    }

}
