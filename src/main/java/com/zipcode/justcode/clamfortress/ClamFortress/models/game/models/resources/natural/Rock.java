package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Rock extends NaturalResource implements ResourceCost, Smeltable {

    public Rock(){
        super("Rock", "Refine rocks to create stones.");
        this.refined = new Stone();
    }

    @Override
    public Stone getRefined() {
        return (Stone) this.refined;
    }

    @Override
    public Rock clone() {
        return new Rock();
    }
}
