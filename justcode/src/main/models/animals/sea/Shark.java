package main.models.animals.sea;

public class Shark extends SeaAnimal {
    @Override
    public Shark clone() {
        return new Shark();
    }
}
