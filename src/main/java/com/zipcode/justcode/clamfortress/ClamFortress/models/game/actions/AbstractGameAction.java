package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions;

public abstract class AbstractGameAction implements Cloneable {

    public boolean isDone;
    public int amountToRun;
    private int amount;

    public AbstractGameAction(int amountToRun) {
        this.amount = 0;
        this.isDone = false;
        this.amountToRun = amountToRun;
    }

    public abstract void update();

    public void reset() {
        this.isDone = false;
        this.amount++;
        if (this.amount >= this.amountToRun) {
            this.isDone = true;
        }
    }

    public void setAmtRemaining(int newAmt) {
        this.amount = newAmt;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    @Override
    public abstract AbstractGameAction clone();

}
