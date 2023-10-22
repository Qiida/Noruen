package noruen.physiology.head.brain.neuron.dendrite;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neuron.Neuron;

public abstract class Dendrite extends Cell {

    final public Body body = new Body();
    final public Neuron neuron;
//    final protected Layer layer;
    int energy;

    public Dendrite(Neuron neuron) {
        super(neuron.x, neuron.y, neuron.z);

        this.neuron = neuron;
//        layer = neuron.layer;
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
