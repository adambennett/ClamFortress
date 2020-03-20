package main.models.animals.land.bears;

public class SlothBear extends AbstractBear {

    public SlothBear() {
        super("Sloth Bear", "The sloth bear is a myrmecophagous bear species native to the Indian subcontinent. It feeds on fruits, ants and termites.", 250);
    }

    @Override
    public SlothBear clone() {
        return new SlothBear();
    }
}
