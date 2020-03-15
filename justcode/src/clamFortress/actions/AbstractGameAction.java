package clamFortress.actions;

import clamFortress.models.beings.player.*;

public abstract class AbstractGameAction {

    protected static final float DEFAULT_DURATION = 0.5f;
    protected float duration;
    protected float startDuration;
    public ActionType actionType;
    public boolean isDone;
    public int amount;
    public Survivor source;
    public Survivor target;

    public AbstractGameAction() {
        this.isDone = false;
    }

    protected void setValues(Survivor target, Survivor source, int amount) {
        this.target = target;
        this.source = source;
        this.amount = amount;
        this.duration = 0.5F;
    }

    protected void  setValues(Survivor source, int amount) {
        this.source = source;
        this.amount = amount;
        this.duration = 0.5F;
    }

    protected void addToBot(AbstractGameAction action) {

    }

    protected void addToTop(AbstractGameAction action) {

    }

    public abstract void update();

    protected void tickDuration() {

    }

    public static enum ActionType {
        BUILDING,
        DEFENDING,
        DISCOVER,
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
        WOODCUTTING;

        private ActionType() {

        }
    }

}
