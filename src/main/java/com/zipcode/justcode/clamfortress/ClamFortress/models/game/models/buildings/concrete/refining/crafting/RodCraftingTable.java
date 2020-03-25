package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.buildings.concrete.refining.crafting;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.hunting.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources.natural.*;

import java.util.*;

public class RodCraftingTable extends AbstractCraftingSpot {

    public RodCraftingTable() {
        super("Rod Crafting Table", 20, new Wood(), new Wood(), new FishingRod());
    }

    @Override
    public ArrayList<AbstractItem> runCraft(int resourceAmt) {
        int count = resourceAmt;
        ArrayList<AbstractItem> toRet = new ArrayList<>();
        while (count > 2) {
            toRet.add(this.craft());
            count -= 3;
        }
        return toRet;
    }

    @Override
    public RodCraftingTable clone() {
        return new RodCraftingTable();
    }

}
