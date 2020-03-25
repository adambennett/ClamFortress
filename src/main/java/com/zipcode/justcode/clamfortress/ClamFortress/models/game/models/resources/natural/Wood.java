package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class Wood extends NaturalResource implements ResourceCost {

    public Wood(){
        super("Wood", "Milled to create Lumber.");
        this.refined = new Lumber();
    }

    @Override
    public Lumber getRefined() {
        return (Lumber) this.refined;
    }

    @Override
    public Wood clone() {
        return new Wood();
    }
}

