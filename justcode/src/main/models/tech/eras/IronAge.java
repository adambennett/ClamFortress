package main.models.tech.eras;

public class IronAge extends Era {

    private static final String localName = "Iron Age";
    private static final String localDesc = "Age #3";

    public IronAge() {
        super(localName, localDesc);
    }

    public IronAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public IronAge clone() {
        return new IronAge();
    }
}
