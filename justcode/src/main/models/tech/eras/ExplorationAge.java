package main.models.tech.eras;

public class ExplorationAge extends Era {

    private static final String localName = "Exploration Age";
    private static final String localDesc = "Age #4";

    public ExplorationAge() {
        super(localName, localDesc);
    }

    public ExplorationAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public ExplorationAge clone() {
        return new ExplorationAge();
    }
}
