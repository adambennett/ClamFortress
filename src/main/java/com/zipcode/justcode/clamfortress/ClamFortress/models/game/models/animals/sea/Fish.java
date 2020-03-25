package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;

public class Fish extends AbstractSeaAnimal {

    public Fish(){
        super("Fish", "Fish are gill-bearing aquatic craniate animals that lack limbs with digits. They form a sister group to the tunicates, together forming the olfactores. Included in this definition are the living hagfish, lampreys, and cartilaginous and bony fish as well as various extinct related groups.", 20);
    }

    @Override
    public Fish clone() {
        return new Fish();
    }
}
