package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Art extends RefinedResource implements ResourceCost {
    public Art() {
        super("Art", "A collection of various artworks and paintings.");
    }

    @Override
    public Art clone() {
        return new Art();
    }
}
