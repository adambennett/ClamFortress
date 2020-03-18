package main.models.buildings.concrete.refining.crafting;

import main.models.buildings.concrete.housing.*;
import main.models.items.*;
import main.models.items.tools.hunting.*;
import main.models.resources.*;
import main.models.resources.natural.*;

import java.util.*;

public class SpearCraftingTable extends AbstractCraftingSpot {

    public SpearCraftingTable() {
        super("Spear Crafting Table", 20, new Wood(), new Wood(), new HuntingSpear());
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
    public SpearCraftingTable clone() {
        return new SpearCraftingTable();
    }

}
