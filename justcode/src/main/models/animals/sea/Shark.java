package main.models.animals.sea;

public class Shark extends AbstractSeaAnimal {

    public Shark(){
        super(175);
    }

    @Override
    public Shark clone() {
        return new Shark();
    }
}
