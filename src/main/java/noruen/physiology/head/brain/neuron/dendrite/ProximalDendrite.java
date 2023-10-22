package noruen.physiology.head.brain.neuron.dendrite;

import noruen.physic.space.cell.Coordinates;
import noruen.physiology.head.brain.neuron.Neuron;

public class ProximalDendrite extends Dendrite{

    public ProximalDendrite(Neuron neuron) {
        super(neuron);
        this.id = String.format("ProximalDendrite_%d_%d_%d", this.x, this.y, this.z);
        grow();

    }

    @Override
    void grow() {

    }
}
