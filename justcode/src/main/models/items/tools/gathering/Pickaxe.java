package main.models.items.tools.gathering;

import main.models.items.tools.AbstractTool;

public class Pickaxe extends AbstractGatheringTool {
    public Pickaxe() {
        super("Pickaxe", "Used to improve Mining.");
    }


    @Override
    public Pickaxe clone() {
        return new Pickaxe();
    }
}