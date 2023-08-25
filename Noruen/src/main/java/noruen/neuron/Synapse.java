package noruen.neuron;

import noruen.neuron.dendrite.Dendrite;
import noruen.space.Element;

public class Synapse extends Element {
    public float growth;
    public Dendrite from;
    public Dendrite to;

    public Synapse(Dendrite from, Dendrite to) {
        super(from.x, from.y, from.z);
        growth = 0.1f;

        this.from = from;
        this.to = to;

    }
}
