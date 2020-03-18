package main.models.resources;

public abstract class NaturalResource extends AbstractResource {

    public RefinedResource refined;

    public RefinedResource getRefined(){
        return this.refined;
    }
}
