package main.models.items.tools.crafting;

import main.models.items.tools.*;

public class PestleAndMortar extends AbstractCraftingTool {
    public PestleAndMortar() {
        super("Pestle and Mortar", "Used to improve Planting.");
    }

    @Override
    public PestleAndMortar clone() {
        return new PestleAndMortar();
    }
}
