package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Lumber extends RefinedResource implements ResourceCost {
    public Lumber() {
        super("Lumber", "Created by milling wood. Used to build basic structures.");
    }

    @Override
    public Lumber clone() {
        return new Lumber();
    }
}
