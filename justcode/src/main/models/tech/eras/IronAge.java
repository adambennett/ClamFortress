package main.models.tech.eras;

public class IronAge extends Era {

    private static final String localName = "Iron Age";

    public IronAge() {
        super(localName);
    }

    public IronAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public IronAge clone() {
        return new IronAge();
    }
}
