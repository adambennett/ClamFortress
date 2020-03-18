package main.models.animals.sea;

import main.models.animals.AbstractAnimal;

public abstract class AbstractSeaAnimal extends AbstractAnimal {
    public AbstractSeaAnimal(int amt) {
        super(amt);
    }

    @Override
    public abstract AbstractSeaAnimal clone();
}
