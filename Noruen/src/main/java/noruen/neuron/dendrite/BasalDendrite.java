package noruen.neuron.dendrite;

import noruen.neuron.Neuron;

public class BasalDendrite extends Dendrite{
    public BasalDendrite(Neuron neuron) {
        super(neuron);
        grow();
    }

    @Override
    void grow() {
//        target = layer.getRandomNeuron();
    }


}
