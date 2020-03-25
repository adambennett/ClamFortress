package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Clay extends NaturalResource implements ResourceCost, Smeltable {


    public Clay(){
        super("Clay", "Used to make Brick.");
        this.refined = new Brick();
    }

    @Override
    public Brick getRefined() {
        return (Brick) this.refined;
    }

    @Override
    public Clay clone() {
        return new Clay();
    }
}
