package main.models.items.tools.crafting;

import main.models.items.military.*;
import main.models.items.tools.*;

public class Anvil extends AbstractCraftingTool {
    public Anvil() {
        super("Anvil", "");
    }

    @Override
    public Anvil clone() {
        return new Anvil();
    }
}
