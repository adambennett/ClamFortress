package main.models.tech.eras;

public class InformationAge extends Era {

    private static final String localName = "Information Age";

    public InformationAge() {
        super(localName);
    }

    public InformationAge(boolean techTreeInit) { super(localName, true); }

    @Override
    public InformationAge clone() {
        return new InformationAge();
    }
}
