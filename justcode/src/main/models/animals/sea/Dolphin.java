package main.models.animals.sea;


public class Dolphin extends AbstractSeaAnimal {

    public Dolphin(){
        super("Dolphin", 115);
    }

    @Override
    public Dolphin clone() {
        return new Dolphin();
    }
}
