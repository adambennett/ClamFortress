package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Brick extends RefinedResource implements ResourceCost {
    public Brick() {
        super("Brick", "Used to craft very sturdy buildings.");
    }

    @Override
    public Brick clone() {
        return new Brick();
    }
}
