package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

public class Jewelery extends RefinedResource implements ResourceCost {
    public Jewelery() {
        super("Jewelery", "Worth quite a lot of money!");
    }

    @Override
    public Jewelery clone() {
        return new Jewelery();
    }
}
