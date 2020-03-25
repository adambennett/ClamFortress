package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Iron extends NaturalResource implements ResourceCost, Smeltable {


    public Iron(){
        super("Iron", "Used to make Iron Ingots.");
        this.refined = new IronIngot();
    }

    @Override
    public IronIngot getRefined() {
        return (IronIngot) this.refined;
    }

    @Override
    public Iron clone() {
        return new Iron();
    }
}
