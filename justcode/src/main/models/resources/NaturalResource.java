package main.models.resources;

public abstract class NaturalResource extends AbstractResource {

    public RefinedResource refined;

    public NaturalResource(String name, String desc) {
        super(name, desc);
    }

    public RefinedResource getRefined(){
        return this.refined;
    }
}
