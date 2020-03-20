package main.models.buildings.concrete.refining.crafting;

import main.models.buildings.abstracts.*;
import main.models.buildings.concrete.housing.*;
import main.models.items.*;
import main.models.resources.*;
import main.models.resources.natural.*;

import java.util.*;

public abstract class AbstractCraftingSpot extends AbstractRefining {

    private AbstractItem craftable;

    public AbstractCraftingSpot(String name, int resourceCost, AbstractResource resourceCostType, AbstractResource toRefine, AbstractItem itemToCraft) {
        super(name, getDesc(name, resourceCost, resourceCostType, toRefine, itemToCraft), resourceCost, resourceCostType, toRefine);
        this.craftable = itemToCraft;
    }

    public static String getDesc(String name, int resourceCost, AbstractResource resourceCostType, AbstractResource toRefine, AbstractItem itemToCraft) {
        String output = "";
        output += name + " [CRAFT][REFINES|" + toRefine.getName() + "]-[CRAFTS|" + itemToCraft.getName() + "]-[COST|" + resourceCost + "x" + resourceCostType.getName() + "]";
        return output;
    }

    public abstract ArrayList<AbstractItem> runCraft(int resourceAmt);

    public AbstractItem getCraftable() {
        return craftable;
    }

    protected AbstractItem craft() {
        return craftable.clone();
    }

    @Override
    public abstract AbstractCraftingSpot clone();
}
