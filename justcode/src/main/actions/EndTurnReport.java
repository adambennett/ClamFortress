package main.actions;

import main.game.logic.*;
import main.utilities.persistence.*;

import java.util.logging.*;

public class EndTurnReport extends AbstractGameAction {

    private Integer dateInc;

    public EndTurnReport(int dateInc) {
        this.dateInc = dateInc;
    }

    @Override
    public void update() {
        String toPrint = "\n\nGlobal Score: " + Database.getPlayerScore() + "\nTime Elapsed: " + dateInc + " Days";
        OutputManager.addToBottom(toPrint);
        OutputManager.print();
        this.isDone = true;
    }
}
