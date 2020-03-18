package main.models.animals.land.bears;

public class Panda extends AbstractBear {

    public Panda() {
        super("Panda", 250);
    }

    @Override
    public Panda clone() {
        return new Panda();
    }
}
