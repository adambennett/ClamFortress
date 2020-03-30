package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.concurrent.*;

public class Seeds extends NaturalResource implements ResourceCost {

    private Integer turnsGrowing;
    private final Integer finishedGrowing;
    private final Integer foodAmt;

    public Seeds() {
        super("Seeds", "Plant them to Harvest a lot of food!");
        this.finishedGrowing = ThreadLocalRandom.current().nextInt(1, 5);
        this.foodAmt = this.finishedGrowing * 4;
        this.turnsGrowing = 0;
    }

    public Integer harvest() {
        if (this.turnsGrowing >= this.finishedGrowing) {
            return this.foodAmt;
        } else {
            this.turnsGrowing++;
        }
        return 0;
    }

    @Override
    public Seeds clone() {
        return new Seeds();
    }
}
