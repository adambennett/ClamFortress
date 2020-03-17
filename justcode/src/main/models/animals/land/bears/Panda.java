package main.models.animals.land.bears;

public class Panda extends Bear {
    @Override
    public Panda clone() {
        return new Panda();
    }
}
