package main.models.animals.land.bears;

public class SlothBear extends Bear {

    public SlothBear(){
        this.amountOfFoodOnHunt = 250;
    }
    @Override
    public SlothBear clone() {
        return new SlothBear();
    }
}
