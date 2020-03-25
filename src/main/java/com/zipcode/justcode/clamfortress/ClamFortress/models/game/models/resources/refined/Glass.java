package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Glass extends RefinedResource implements ResourceCost {
    public Glass() {
        super("Glass", "Created from Sand. Used to decorate your buildings.");
    }

    @Override
    public Glass clone() {
        return new Glass();
    }
}
