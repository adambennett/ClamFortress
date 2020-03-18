package main.models.managers;

import main.actions.*;
import main.models.*;
import main.models.items.*;

import java.util.*;

public class ActionManager {

    public ArrayList<AbstractGameAction> actions = new ArrayList<>();
    public ArrayList<AbstractGameAction> preTurnActions = new ArrayList<>();
    public ArrayList<AbstractGameAction> postTurnActions = new ArrayList<>();
    public AbstractGameAction finalAction;
    public AbstractGameAction current;
    public AbstractGameAction previous;
    public Phase phase;
    public boolean hasControl;

    public ActionManager() {
        this.phase = Phase.WAITING_ON_USER;
        this.hasControl = true;
    }

    public void addToBottom(AbstractGameAction action) {
        this.actions.add(action);
    }

    public void addToTop(AbstractGameAction action) {
        this.actions.add(0, action);
    }

    public void addToTurnStart(AbstractGameAction action) {
        this.preTurnActions.add(action);
    }

    public void addToTurnEnd(AbstractGameAction action) {
        this.postTurnActions.add(action);
    }

    public void setAbsoluteLastAction(AbstractGameAction action) { this.finalAction = action; }

    public void update() {
        switch (this.phase) {
            case WAITING_ON_USER:
                this.getNextAction();
                break;
            case EXECUTING_ACTIONS:
                if (this.current != null && !this.current.isDone) {
                    this.current.update();
                }

                else {
                    this.previous = this.current;
                    for (AbstractItem item : Game.getVillage().getInventory().getItems()) {
                        item.afterRunAction(this.current);
                    }
                    this.current = null;
                    this.getNextAction();
                    // if (waiting on player input) {
                    //  this.phase = Phase.WAITING_ON_USER;
                    //  this.hasControl = false;
                    // }
                }
                break;
        }
    }

    private void getNextAction() {
        if (!this.preTurnActions.isEmpty()) {
            this.current = this.preTurnActions.remove(0);
            this.phase = Phase.EXECUTING_ACTIONS;
            this.hasControl = true;
        }

        else if (!this.actions.isEmpty()) {
            this.current = this.actions.remove(0);
            this.phase = Phase.EXECUTING_ACTIONS;
            this.hasControl = true;
        }

        else if (!this.postTurnActions.isEmpty()) {
            this.current = this.postTurnActions.remove(0);
            this.phase = Phase.EXECUTING_ACTIONS;
            this.hasControl = true;
        }

        else if (this.finalAction != null && !this.finalAction.isDone) {
            this.finalAction.update();
        }
    }

    public enum Phase {
        WAITING_ON_USER,
        EXECUTING_ACTIONS;

        Phase() {
        }
    }

}
