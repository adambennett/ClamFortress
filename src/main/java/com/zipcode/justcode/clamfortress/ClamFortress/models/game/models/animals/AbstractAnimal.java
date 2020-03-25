package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.animals;


import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;

import javax.persistence.*;

@Entity
public abstract class AbstractAnimal extends GameObject {

    @Id
    @ManyToOne(optional = false)
    @JoinTable(name = "animals")
    private Board board;

    @Column(nullable = false, name = "amountOfFoodOnHunt")
    private Integer amountOfFoodOnHunt;

    public AbstractAnimal() { super("Animal", "Description"); }

    public AbstractAnimal(String name, String desc, int amt) {
        super(name, desc);
        this.amountOfFoodOnHunt = amt;
    }

    public Integer getAmountOfFoodOnHunt(){
        return this.amountOfFoodOnHunt;
    }

    public void setAmountOfFoodOnHunt(int amt) {
        this.amountOfFoodOnHunt = amt;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setAmountOfFoodOnHunt(Integer amountOfFoodOnHunt) {
        this.amountOfFoodOnHunt = amountOfFoodOnHunt;
    }

    @Override
    public abstract AbstractAnimal clone();

}
