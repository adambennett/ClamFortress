package main.models.animals.sea;

public class Platypus extends SeaAnimal {

    public Platypus(){
        super(20);
    }

    @Override
    public Platypus clone() {
        return new Platypus();
    }
}
