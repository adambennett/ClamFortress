package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.tech.eras;

public class IndustrialAge extends Era {

    private static final String localName = "Industrial Age";
    private static final String localDesc = "Age #5";

    public IndustrialAge() {
        super(localName, localDesc);
    }

    public IndustrialAge(boolean techTreeInit) { super(localName, localDesc, true); }

    @Override
    public IndustrialAge clone() {
        return new IndustrialAge();
    }
}
