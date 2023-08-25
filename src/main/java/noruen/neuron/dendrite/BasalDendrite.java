package noruen.neuron.dendrite;

import noruen.neuron.Neuron;
import noruen.space.Cell;

public class BasalDendrite extends Dendrite {
    public BasalDendrite(Neuron neuron) {
        super(neuron);
        grow();
    }

    @Override
    void grow() {
        Cell neighbour = neuron.layer.getRandomNeighbourOfCell(neuron);
        body.add(neighbour);
    }
}
