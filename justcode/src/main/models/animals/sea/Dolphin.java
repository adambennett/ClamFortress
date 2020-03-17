package main.models.animals.sea;


public class Dolphin extends SeaAnimal {
    @Override
    public Dolphin clone() {
        return new Dolphin();
    }
}
