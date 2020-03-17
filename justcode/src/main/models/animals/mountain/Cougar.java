package main.models.animals.mountain;

public class Cougar extends MountainAnimal {

    public Cougar(){
        super(145);
    }

    @Override
    public Cougar clone() {
        return new Cougar();
    }
}
