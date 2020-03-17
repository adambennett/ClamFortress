package main.models.animals.sea;


public class Dolphin extends SeaAnimal {

    public Dolphin(){
        super(115);
    }

    @Override
    public Dolphin clone() {
        return new Dolphin();
    }
}
