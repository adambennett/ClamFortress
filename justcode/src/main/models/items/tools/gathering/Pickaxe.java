package main.models.items.tools.gathering;

import main.models.items.tools.AbstractTool;

public class Pickaxe extends AbstractGatheringTool {
    public Pickaxe() {
        super("Pickaxe", "");
    }


    @Override
    public Pickaxe clone() {
        return new Pickaxe();
    }
}