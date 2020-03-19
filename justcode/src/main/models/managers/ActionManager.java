package main.models.managers;

import main.actions.*;
import main.enums.*;

import java.util.*;
import java.util.logging.*;

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

    public void requeue(AbstractGameAction action) {
        if (this.actions.size() > 1) {
            this.actions.add(this.actions.size() - 2, action);
        } else {
            addToBottom(action);
        }
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
            case EXECUTING:
                if (this.current != null) {
                    if (this.current.isDone) {
                        this.current.reset();
                        this.previous = this.current;
                        if (!this.current.isDone) {
                            addToTop(this.current);
                        }
                        this.getNextAction();
                    } else if (this.current.amountToRun > 0){
                        this.current.update();
                    } else {
                        this.getNextAction();
                    }
                } else {
                    Logger.getGlobal().warning("ActionManager got a null for current action!");
                }
                break;
        }
    }

    private void getNextAction() {
        if (!this.preTurnActions.isEmpty()) {
            this.current = this.preTurnActions.remove(0);
            this.phase = Phase.EXECUTING;
            this.hasControl = true;
        }

        else if (!this.actions.isEmpty()) {
            this.current = this.actions.remove(0);
            this.phase = Phase.EXECUTING;
            this.hasControl = true;
        }

        else if (!this.postTurnActions.isEmpty()) {
            this.current = this.postTurnActions.remove(0);
            this.phase = Phase.EXECUTING;
            this.hasControl = true;
        }

        else if (this.finalAction != null && !this.finalAction.isDone) {
            this.previous = this.current;
            this.current = this.finalAction;
            this.phase = Phase.EXECUTING;
            this.hasControl = true;
        }
    }



}
