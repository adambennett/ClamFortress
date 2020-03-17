package main.models.animals.sea;

public class Whale extends SeaAnimal {
    @Override
    public Whale clone() {
        return new Whale();
    }
}
