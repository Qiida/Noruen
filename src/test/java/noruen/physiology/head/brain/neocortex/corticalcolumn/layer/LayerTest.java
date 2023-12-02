package noruen.physiology.head.brain.neocortex.corticalcolumn.layer;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neocortex.corticalcolumn.layer.Layer;
import noruen.physiology.head.brain.neuron.Neuron;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LayerTest {

    @Test
    public void constructorTest() {
        Layer layer = new Layer(10, 10, 4);
    }

    @Test
    public void getTotalEnergyTest() {
        Layer layer = new Layer(10, 1, 4);
        int energy = layer.getTotalEnergy();
        Assertions.assertTrue(energy > 0);
    }

    @Test
    public void getNumberOfNeuronsTest() {
        Layer layer = new Layer(10, 1, 4);
        Assertions.assertEquals(40, layer.getNumberOfNeurons());
    }

    @Test
    public void getListOfNeuronsTest() {
        Layer layer = new Layer(10, 1, 4);
        List<Neuron> neuronList = layer.getListOfNeurons();
        Assertions.assertEquals(40, layer.getNumberOfNeurons());
    }

    @Test
    public void getListOfSortedNeuronsTest() {
        Layer layer = new Layer(10, 1, 4);
        ArrayList<Neuron> sortedNeurons = layer.getListOfSortedNeurons();

        Neuron bigger = null;
        for (int i=0; i<sortedNeurons.size(); i++) {
            if (i != 0) {
                Assertions.assertTrue(bigger.energy >= sortedNeurons.get(i).energy);
            }
            bigger = sortedNeurons.get(i);
        }

    }

    @Test
    public void getFiringNeurons() {
        Layer layer = new Layer(4,10, 1, 4, 0.3f);
        ArrayList<Neuron> firingNeurons = layer.getFiringNeurons();
        Assertions.assertEquals(12, firingNeurons.size());
    }

    @Test
    public void getTargetCoordinatesInDirectionTest() {
        Layer layer = new Layer(4,10, 1, 4, 0.3f);
        Cell cell = layer.cells[0][0][0].getNeuron();
        int[] direction = {-1, 1, 1};

        Cell neighbour = layer.getNeighbourCellInDirection(direction, cell);

    }

}
