package main.models.items.tools.crafting;

import main.models.items.tools.*;

public class PestleAndMortar extends AbstractCraftingTool {
    public PestleAndMortar() {
        super("Pestle and Mortar", "");
    }

    @Override
    public PestleAndMortar clone() {
        return new PestleAndMortar();
    }
}
