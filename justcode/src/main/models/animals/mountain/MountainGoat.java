package main.models.animals.mountain;

public class MountainGoat extends MountainAnimal {

    public MountainGoat(){
        this.amountOfFoodOnHunt = 75;
    }

    @Override
    public MountainGoat clone() {
        return new MountainGoat();
    }
}
