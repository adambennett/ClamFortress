package zipcoder.actions;

import zipcoder.models.beings.*;

public class Defense extends AbstractGameAction {

    public Defense(Survivor source, int amount) {
        this.setValues(source, amount);
        this.actionType = ActionType.DEFENDING;
    }

    @Override
    public void update() {
        // do building logic
    }
}
