package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.crafting;

public class Anvil extends AbstractCraftingTool {
    public Anvil() {
        super("Anvil", "Used to improve Smithing.");
    }

    @Override
    public Anvil clone() {
        return new Anvil();
    }
}
