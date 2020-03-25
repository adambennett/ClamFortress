package com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.nodes.biomes;

import com.zipcode.justcode.clamfortress.ClamFortress.models.game.models.*;

import javax.persistence.*;

@Entity
public abstract class AbstractBiome {

    @Id
    @OneToOne(optional = false)
    private Board board;

    public AbstractBiome(){}

    @Override
    public abstract String toString();

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
