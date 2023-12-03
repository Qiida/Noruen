package noruen.app.neurongrowlab;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neocortex.corticalcolumn.layer.Layer;
import noruen.physiology.head.brain.neuron.Neuron;
import noruen.physiology.head.brain.neuron.dendrite.BasalDendrite;

import java.util.ArrayList;

public class NeuronGrowLab {

    public static void main(String[] args) {

        System.out.println("""
                \n\n
                ███    ██  ██████  ██████  ██    ██ ███████ ███    ██\s
                ████   ██ ██    ██ ██   ██ ██    ██ ██      ████   ██\s
                ██ ██  ██ ██    ██ ██████  ██    ██ █████   ██ ██  ██\s
                ██  ██ ██ ██    ██ ██   ██ ██    ██ ██      ██  ██ ██\s
                ██   ████  ██████  ██   ██  ██████  ███████ ██   ████\s
                                                                     \s
                                                                     \s
                """);
        System.out.println("\n\nThis is a Lab to grow Neurons.\n\n");


        System.out.println("We create a Cortical Layer and populate it with neurons.");
        Layer layer = new Layer(10, 20, 10, 0);
        layer.setVerbose(false);

        int numberOfNeurons = layer.getNumberOfNeurons();
        System.out.printf("The layer contains " + numberOfNeurons + " neurons.");

        int numberOfIterations = 10000;
        for (int i=0; i<numberOfIterations; i++) {
            ArrayList<Neuron> firingNeurons = layer.getFiringNeurons();
            for (Neuron neuron : firingNeurons) {
                neuron.fire();
            }

        }

        for (Neuron neuron : layer.getListOfNeurons()) {
            System.out.println(neuron.id + "\n");
            printDendriteGrowth(neuron);
        }
        System.out.println("\n\nThe End.");

    }

    private static void printDendriteGrowth(Neuron neuron) {
        for (BasalDendrite basalDendrite : neuron.basalDendrites) {
            for (Cell cell : basalDendrite.body.list()) {
                int[] direction = basalDendrite.body.direction;
                if (direction != null) System.out.printf("(%d %d %d) ", direction[0], direction[1], direction[2]);
                System.out.println(cell.id);
            }
        }
    }
}
