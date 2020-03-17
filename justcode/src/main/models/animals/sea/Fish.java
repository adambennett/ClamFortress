package main.models.animals.sea;

public class Fish extends SeaAnimal {
    @Override
    public Fish clone() {
        return new Fish();
    }
}
