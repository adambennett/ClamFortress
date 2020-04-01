package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.persistence.*;

public class Defense extends AbstractGameAction {

    public Defense(int amountToRun) {
        super(amountToRun);
    }

    @Override
    public void update() {
        Integer defense = Database.getCurrentGame().getVillage().getDefense();
        while (defense >4){
           // Database.getCurrentGame().getVillage().reduceBandits();
            defense-=5;
        }
        this.isDone = true;
    }

    @Override
    public Defense clone() {
        return new Defense(this.amountToRun);
    }
}