package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Stone extends RefinedResource implements ResourceCost {
    public Stone() {
        super("Stone", "Refined, smoothed, rocks.");
    }

    @Override
    public Stone clone() {
        return new Stone();
    }
}
