package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.refined.*;

public class GoldenWood extends NaturalResource implements ResourceCost, Golden {

    public GoldenWood(){
        super("Golden Wood", "Milled to create Lumber. Worth 10 Coins upon pickup.");
        this.refined = new Lumber();
    }

    @Override
    public Lumber getRefined() {
        return (Lumber) this.refined;
    }

    @Override
    public GoldenWood clone() {
        return new GoldenWood();
    }

    @Override
    public Integer getGoldAmt() {
        return 10;
    }
}

