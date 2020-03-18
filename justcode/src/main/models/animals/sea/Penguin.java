package main.models.animals.sea;



public class Penguin extends AbstractSeaAnimal {

    public Penguin(){
        super(24);
    }

    @Override
    public Penguin clone() {
        return new Penguin();
    }
}
