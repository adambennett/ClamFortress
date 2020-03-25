package com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.priority;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.actions.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.utilities.stringUtils.*;

public class Raiding extends AbstractGameAction {

    private final City city;

    public Raiding(City cityNode, int amtToRun) {
        super(amtToRun);
        this.city = cityNode;
    }

    @Override
    public void update() {
        if (this.city != null && !this.city.getDefeated()) {
            Game.getVillage().takeDamage(city.dealDamage());
            city.takeDamage(Game.getVillage().dealDamage());
        }

        if (this.getAmount() == this.amountToRun) {
            StringHelpers.reloadStrings();
        }
        this.isDone = true;
    }

    @Override
    public Raiding clone() {
        return new Raiding(this.city, this.amountToRun);
    }
}
