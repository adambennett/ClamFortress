package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.interfaces.*;

public class GoldenAxe extends AbstractGatheringTool implements Golden {
    public GoldenAxe() {
        super("Golden Axe", "Enables the ability to chop Golden Wood sometimes while Woodcutting. Worth 50 Coins upon pickup.");
    }

    @Override
    public GoldenAxe clone() {
        return new GoldenAxe();
    }

    @Override
    public Integer getGoldAmt() {
        return 50;
    }
}