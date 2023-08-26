package noruen.neuron.dendrite;

import noruen.space.Cell;
import noruen.sdr.SDR;
import noruen.space.Layer;
import noruen.neuron.Neuron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

public abstract class Dendrite extends Cell {

    final public Body body = new Body();
    final public Neuron neuron;
    final protected Layer layer;
    int energy;

    public Dendrite(Neuron neuron) {
        super(neuron.x, neuron.y, neuron.z);

        this.neuron = neuron;
        layer = neuron.layer;
    }



    abstract void grow();

    public void receivesEnergy(Integer energy) {
        this.energy += energy;
    }

    public void transmitsEnergy() {
        // TODO: energy class
        energy--;
    }
}
