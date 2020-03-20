package main.models.animals.land.bears;

public class CaveBear extends AbstractBear {

    public CaveBear() {
        super("Cave Bear", "The cave bear was a species of bear that lived in Europe and Asia during the Pleistocene and became extinct about 24,000 years ago during the Last Glacial Maximum. Both the word \"cave\" and the scientific name spelaeus are used because fossils of this species were mostly found in caves.", 250);
    }

    @Override
    public CaveBear clone() {
        return new CaveBear();
    }
}
