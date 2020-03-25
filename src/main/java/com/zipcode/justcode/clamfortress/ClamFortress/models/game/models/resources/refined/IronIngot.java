package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class IronIngot extends RefinedResource {
    public IronIngot() {
        super("Iron Ingot", "Created from Iron. Used for a handful of different purposes.");
    }

    @Override
    public IronIngot clone() {
        return new IronIngot();
    }
}
