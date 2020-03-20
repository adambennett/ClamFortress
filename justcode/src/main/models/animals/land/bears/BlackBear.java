package main.models.animals.land.bears;

public class BlackBear extends AbstractBear {

    public BlackBear() {
        super("Black Bear","TThe American black bear is a medium-sized bear native to North America. It is the continent's smallest and most widely distributed bear species. American black bears are omnivores, with their diets varying greatly depending on season and location.", 250);
    }

    @Override
    public BlackBear clone() {
        return new BlackBear();
    }
}
