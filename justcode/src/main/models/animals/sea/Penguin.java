package main.models.animals.sea;



public class Penguin extends SeaAnimal {
    @Override
    public Penguin clone() {
        return new Penguin();
    }
}
