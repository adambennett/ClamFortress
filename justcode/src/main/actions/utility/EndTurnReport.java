package main.actions.utility;

import jdk.nashorn.internal.objects.*;
import main.actions.*;
import main.enums.*;
import main.models.managers.*;
import main.utilities.persistence.*;

public class EndTurnReport extends AbstractGameAction {

    private Integer dateInc;

    public EndTurnReport(int dateInc) {
        super(1);
        this.dateInc = dateInc;
    }

    @Override
    public void update() {
        String toPrint;
        if (OutputManager.getExp() > 0) {
            toPrint = "\nGained " + OutputManager.getExp() + " experience\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days";
        } else {
            toPrint = "\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days";
        }
        OutputManager.addToBot(OutputFlag.TIME_ELAPSED, toPrint);
        OutputManager.print();
        this.isDone = true;
    }

    @Override
    public EndTurnReport clone() {
        return new EndTurnReport(this.dateInc);
    }
}
