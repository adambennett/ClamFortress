package main.models.animals.sea;



public class Penguin extends SeaAnimal {

    public Penguin(){
        super(24);
    }

    @Override
    public Penguin clone() {
        return new Penguin();
    }
}
