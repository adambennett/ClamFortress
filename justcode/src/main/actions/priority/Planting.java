package main.actions.priority;

import main.actions.*;

public class Planting extends AbstractGameAction {

    public Planting(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        /*First check if they have any seeds if no output no seeds in inv
        next check if the planted flag has been set
        reduce
        * */


        this.isDone = true;
    }

    @Override
    public Planting clone() {
        return new Planting(this.amountToRun);
    }
}
