package main.models.animals.mountain;

public class Cougar extends AbstractMountainAnimal {

    public Cougar(){
        super(145);
    }

    @Override
    public Cougar clone() {
        return new Cougar();
    }
}
