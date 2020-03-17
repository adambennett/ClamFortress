package main.models.animals.land.bears;

public class SlothBear extends Bear {

    public SlothBear() {
        super(250);
    }

    @Override
    public SlothBear clone() {
        return new SlothBear();
    }
}
