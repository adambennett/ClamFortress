package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.mountain;

public class MountainHare extends AbstractMountainAnimal {

    public MountainHare(){
        super("Mountain Hare", "The mountain hare, also known as blue hare, tundra hare, variable hare, white hare, snow hare, alpine hare, and Irish hare, is a Palearctic hare that is largely adapted to polar and mountainous habitats.", 8);
    }

    @Override
    public MountainHare clone() {
        return new MountainHare();
    }
}
