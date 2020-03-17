package main.actions.priority;

import main.actions.*;
import main.models.*;

public class Defense extends AbstractGameAction {

    @Override
    public void update() {
        Integer defense = Game.getVillage().getDefense();
        while (defense >4){
            Game.getVillage().reduceBandits();
            defense-=5;
        }
        this.isDone = true;
    }

    @Override
    public Defense clone() {
        return new Defense();
    }
}