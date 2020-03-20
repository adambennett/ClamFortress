package main.models.items.tools.gathering;

import main.interfaces.*;

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