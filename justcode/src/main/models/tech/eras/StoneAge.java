package main.models.tech.eras;

public class StoneAge extends Era {

    private static final String localName = "Stone Age";

    public StoneAge() {
        super(localName);
    }

    public StoneAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public StoneAge clone() {
        return new StoneAge();
    }
}
