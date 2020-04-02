package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.resources;


import com.fasterxml.jackson.annotation.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.*;
import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.other.*;

import javax.persistence.*;

@Entity
public abstract class AbstractResource extends GameObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Board board;

    @ManyToOne
    @JsonIgnore
    private Village village;

    public AbstractResource() { super("", ""); }

    public AbstractResource(String name, String desc) {
        super(name, desc);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public abstract AbstractResource clone();
}
