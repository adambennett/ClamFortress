package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.crafting;

public class PestleAndMortar extends AbstractCraftingTool {
    public PestleAndMortar() {
        super("Pestle and Mortar", "Used to improve Planting.");
    }

    @Override
    public PestleAndMortar clone() {
        return new PestleAndMortar();
    }
}
