package main.actions.utility;

import main.actions.*;
import main.enums.*;
import main.models.managers.*;
import main.utilities.persistence.*;

public class EndTurnReport extends AbstractGameAction {

    private Integer dateInc;

    public EndTurnReport(int dateInc) {
        this.dateInc = dateInc;
    }

    @Override
    public void update() {
        String toPrint = "\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days";
        OutputManager.addToBot(OutputFlag.TIME_ELAPSED, toPrint);
        OutputManager.print();
        this.isDone = true;
    }

    @Override
    public EndTurnReport clone() {
        return new EndTurnReport(this.dateInc);
    }
}
