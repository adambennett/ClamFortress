package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class CopperIngot extends RefinedResource {
    public CopperIngot() {
        super("Copper Ingot", "Created from Copper. Used for various purposes.");
    }

    @Override
    public CopperIngot clone() {
        return new CopperIngot();
    }
}
