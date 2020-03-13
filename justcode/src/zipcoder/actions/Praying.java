package zipcoder.actions;

import zipcoder.models.beings.*;

public class Praying extends AbstractGameAction {

    public Praying(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.PRAYING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
