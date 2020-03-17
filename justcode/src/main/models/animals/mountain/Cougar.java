package main.models.animals.mountain;

public class Cougar extends MountainAnimal {

    public Cougar(){
        this.amountOfFoodOnHunt = 145;
    }

    @Override
    public Cougar clone() {
        return new Cougar();
    }
}
