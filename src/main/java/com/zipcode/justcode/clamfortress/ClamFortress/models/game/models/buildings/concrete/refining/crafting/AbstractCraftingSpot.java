package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.refining.crafting;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.abstracts.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.*;

import java.util.*;

public abstract class AbstractCraftingSpot extends AbstractRefining {

    private AbstractItem craftable;

    public AbstractCraftingSpot(String name, int resourceCost, AbstractResource resourceCostType, AbstractResource toRefine, AbstractItem itemToCraft) {
        super(name, getDesc(resourceCost, resourceCostType, toRefine, itemToCraft), resourceCost, resourceCostType, toRefine);
        this.craftable = itemToCraft;
    }

    public static String getDesc(int resourceCost, AbstractResource resourceCostType, AbstractResource toRefine, AbstractItem itemToCraft) {
        String output = "";
        output += "[Refines: " + toRefine.getName() + "] - [Crafts: " + itemToCraft.getName() + "] - [Cost: " + resourceCost + "x" + resourceCostType.getName() + "]";
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
