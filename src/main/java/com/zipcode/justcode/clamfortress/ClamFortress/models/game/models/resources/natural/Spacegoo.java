package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Spacegoo extends NaturalResource implements ResourceCost {
    public Spacegoo() {
        super("Spacegoo", "Worth a LOT of money!! Or should you use it?");
    }

    @Override
    public Spacegoo clone() {
        return new Spacegoo();
    }
}
