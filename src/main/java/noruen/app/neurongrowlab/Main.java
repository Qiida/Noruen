package noruen.app.neurongrowlab;

import noruen.neuron.Neuron;
import noruen.neuron.dendrite.BasalDendrite;
import noruen.space.Cell;
import noruen.space.Layer;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\nThis is a Lab to grow Neurons.\n\n");

        System.out.println("We create a Cortical Layer and populate it with neurons.");
        Layer layer = new Layer(100, 4, 1, 0);
        layer.setVerbose(false);

        int numberOfNeurons = layer.getNumberOfNeurons();
        System.out.printf("The layer contains " + numberOfNeurons + " neurons.");

        int numberOfIterations = 407;
        for (int i=0; i<numberOfIterations; i++) {
            if (i==406) {
                System.out.println("Stop!");
            }
            System.out.println(i);
            ArrayList<Neuron> firingNeurons = layer.getFiringNeurons();
            for (Neuron neuron : firingNeurons) {
                // bug at neuron number 7 or 8
                neuron.fire();
            }

        }

        for (Neuron neuron : layer.getListOfNeurons()) {
            System.out.println(neuron.id + "\n");
            printDendriteGrowth(neuron);
        }

        System.out.println("The End.");


    }

    private static void printDendriteGrowth(Neuron neuron) {
        for (BasalDendrite basalDendrite : neuron.basalDendrites) {
            for (Cell cell : basalDendrite.body.list()) {
                int[] direction = basalDendrite.body.direction;
                if (direction != null) System.out.printf("[%d][%d][%d]", direction[0], direction[1], direction[2]);
                System.out.println(cell.id);
            }
        }
    }
}

