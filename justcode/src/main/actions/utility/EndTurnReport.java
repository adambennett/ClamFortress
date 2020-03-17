package main.actions.utility;

import jdk.nashorn.internal.objects.*;
import main.actions.*;
import main.enums.*;
import main.models.managers.*;
import main.utilities.persistence.*;

public class EndTurnReport extends AbstractGameAction {

    private Integer dateInc;
    private Integer actions;

    public EndTurnReport(int dateInc, int actions) {
        this.dateInc = dateInc;
        this.actions = actions;
    }

    @Override
    public void update() {
        String toPrint = "\n\nActions Ran: " + this.actions + "\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days";
        OutputManager.addToBot(toPrint, OutputFlag.TIME_ELAPSED);
        OutputManager.print();
        this.isDone = true;
    }

    @Override
    public EndTurnReport clone() {
        return new EndTurnReport(this.dateInc, this.actions);
    }
}
