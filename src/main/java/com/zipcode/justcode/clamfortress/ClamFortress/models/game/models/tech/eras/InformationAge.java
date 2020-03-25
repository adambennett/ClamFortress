package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;

public class InformationAge extends Era {

    private static final String localName = "Information Age";
    private static final String localDesc = "Age #6";

    public InformationAge() {
        super(localName, localDesc);
    }

    public InformationAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public InformationAge clone() {
        return new InformationAge();
    }
}
