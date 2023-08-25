package noruen.neuron.dendrite;

import noruen.space.Cell;
import noruen.sdr.SDR;
import noruen.space.Layer;
import noruen.neuron.Neuron;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class Dendrite extends Cell {

    final public List<Cell> body = new ArrayList<>();
    final public Neuron neuron;
    final protected Layer layer;
    int energy;

    public Dendrite(Neuron neuron) {
        super(neuron.x, neuron.y, neuron.z);

        this.neuron = neuron;
//        body.add();

        layer = neuron.layer;
    }



    abstract void grow();
}
