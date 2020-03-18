package main.models.buildings.concrete.refining.crafting;

import main.models.buildings.abstracts.*;
import main.models.items.*;
import main.models.resources.*;
import main.models.resources.natural.*;

import java.util.*;

public abstract class AbstractCraftingSpot extends AbstractRefining {

    private AbstractItem craftable;

    public AbstractCraftingSpot(String name, int resourceCost, AbstractResource resourceCostType, AbstractResource toRefine, AbstractItem itemToCraft) {
        super(name, resourceCost, resourceCostType, toRefine);
        this.craftable = itemToCraft;
    }

    public abstract ArrayList<AbstractItem> runCraft(int resourceAmt);

    public AbstractItem getCraftable() {
        return craftable;
    }

    protected AbstractItem craft() {
        return craftable.clone();
    }
}
