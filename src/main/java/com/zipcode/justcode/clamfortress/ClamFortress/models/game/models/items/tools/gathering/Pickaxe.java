package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.items.tools.gathering;

public class Pickaxe extends AbstractGatheringTool {
    public Pickaxe() {
        super("Pickaxe", "Used to improve Mining.");
    }


    @Override
    public Pickaxe clone() {
        return new Pickaxe();
    }
}