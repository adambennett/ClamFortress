package clamFortress.actions;

import clamFortress.game.*;
import clamFortress.models.beings.player.*;

public abstract class AbstractGameAction {

    protected float duration;
    public ActionType actionType;
    public boolean isDone;
    public int amount;
    public Game currentGame;

    public AbstractGameAction() {
        this.isDone = false;
    }

    protected void setValues(Game game, int amount) {
        this.currentGame = game;
        this.amount = amount;
        this.duration = 0.5F;
    }

    protected void setValues(Game game) {
        this.currentGame = game;
        this.amount = 0;
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
