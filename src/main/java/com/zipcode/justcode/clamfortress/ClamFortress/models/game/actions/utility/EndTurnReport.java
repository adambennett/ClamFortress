package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.utility;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.enums.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.managers.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

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
            toPrint = "\nGained " + OutputManager.getExp() + " experience\nGlobal Score: " + StatTracker.getOverallScore() + "\nTime Elapsed: " + dateInc + " Days";
        } else {
            toPrint = "\nGlobal Score: " + StatTracker.getOverallScore() + "\nTime Elapsed: " + dateInc + " Days";
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
