package main.models.animals.sea;

public class Seal extends SeaAnimal {
    @Override
    public Seal clone() {
        return new Seal();
    }
}
