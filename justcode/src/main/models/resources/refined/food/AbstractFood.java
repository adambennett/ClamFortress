package main.models.resources.refined.food;

import main.models.resources.*;

public abstract class AbstractFood extends AbstractResource {

    private Integer healing;

    public AbstractFood(Integer healing, String name, String desc) {
        super(name, desc);
        this.healing = healing;
    }

    public Integer getHealing() {
        return healing;
    }

    public void setHealing(Integer healing) {
        this.healing = healing;
    }
}
