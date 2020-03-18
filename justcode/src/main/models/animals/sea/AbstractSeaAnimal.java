package main.models.animals.sea;

import main.models.animals.AbstractAnimal;

public abstract class AbstractSeaAnimal extends AbstractAnimal {
    public AbstractSeaAnimal(String name, int amt) {
        super(name, amt);
    }

    @Override
    public abstract AbstractSeaAnimal clone();
}
