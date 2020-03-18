package main.models.tech.eras;

public class ExplorationAge extends Era {

    private static final String localName = "Exploration Age";

    public ExplorationAge() {
        super(localName);
    }

    public ExplorationAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public ExplorationAge clone() {
        return new ExplorationAge();
    }
}
