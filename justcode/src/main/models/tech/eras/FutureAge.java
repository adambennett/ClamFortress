package main.models.tech.eras;

public class FutureAge extends Era {

    private static final String localName = "Future";

    public FutureAge() {
        super(localName);
    }

    public FutureAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public FutureAge clone() {
        return new FutureAge();
    }
}
