package main.models.animals.land.bears;

public class Panda extends AbstractBear {

    public Panda() {
        super(250);
    }

    @Override
    public Panda clone() {
        return new Panda();
    }
}
