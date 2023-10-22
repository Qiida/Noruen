package noruen.physiology.head.brain.neuron;

import noruen.physiology.head.brain.neocortex.corticalcolumn.layer.Layer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class NeuronTest {
    private final Layer layer = new Layer(100, 100, 4, 0);

    @Test
    public void fireTest() {
        layer.setVerbose(false);

        ArrayList<Neuron> firingNeurons = layer.getFiringNeurons();
        for (Neuron neuron : firingNeurons) {
            neuron.fire();
        }

    }
}
