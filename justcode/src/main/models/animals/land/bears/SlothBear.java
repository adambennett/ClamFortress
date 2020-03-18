package main.models.animals.land.bears;

public class SlothBear extends AbstractBear {

    public SlothBear() {
        super("Sloth Bear", 250);
    }

    @Override
    public SlothBear clone() {
        return new SlothBear();
    }
}
