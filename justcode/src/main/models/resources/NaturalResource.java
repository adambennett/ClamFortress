package main.models.resources;

public abstract class NaturalResource extends AbstractResource {

    public RefinedResource refined;

    public NaturalResource(String name) {
        super(name);
    }

    public RefinedResource getRefined(){
        return this.refined;
    }
}
