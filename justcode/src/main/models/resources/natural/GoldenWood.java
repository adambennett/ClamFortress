package main.models.resources.natural;

import main.interfaces.*;
import main.models.resources.*;
import main.models.resources.refined.*;


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

