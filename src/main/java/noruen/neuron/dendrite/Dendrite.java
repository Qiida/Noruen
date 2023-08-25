package noruen.neuron.dendrite;

import noruen.space.Element;
import noruen.sdr.SDR;
import noruen.space.Layer;
import noruen.neuron.Neuron;

public abstract class Dendrite extends Element {
    private final Neuron neuron;

    public Element target;

    final protected Layer layer;
    int energy;

    public Dendrite(Neuron neuron) {
        super(neuron.x, neuron.y, neuron.z);
        this.neuron = neuron;
        layer = neuron.layer;
    }

    public void detect(SDR sdr) {
        SDR overlap = sdr.overlap(sdr);
        energy = overlap.getOnBits().size();
    }

    abstract void grow();
}
