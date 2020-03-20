package main.models.animals.sea;

import main.models.animals.AbstractAnimal;

public abstract class AbstractSeaAnimal extends AbstractAnimal {
    public AbstractSeaAnimal(String name, String desc, int amt) {
        super(name, desc, amt);
    }

    @Override
    public abstract AbstractSeaAnimal clone();
}
