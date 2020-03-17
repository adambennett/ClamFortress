package main.models.animals.mountain;

public class MountainHare extends MountainAnimal {

    public MountainHare(){
        this.amountOfFoodOnHunt = 8;
    }

    @Override
    public MountainHare clone() {
        return new MountainHare();
    }
}
