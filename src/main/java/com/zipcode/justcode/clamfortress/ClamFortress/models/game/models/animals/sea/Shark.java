package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals.sea;

public class Shark extends AbstractSeaAnimal {

    public Shark(){
        super("Shark", "Sharks are a group of elasmobranch fish characterized by a cartilaginous skeleton, five to seven gill slits on the sides of the head, and pectoral fins that are not fused to the head. Modern sharks are classified within the clade Selachimorpha and are the sister group to the rays. ", 175);
    }

    @Override
    public Shark clone() {
        return new Shark();
    }
}
