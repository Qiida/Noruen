package noruen.neuron.dendrite;

import noruen.neuron.CellType;
import noruen.neuron.Neuron;
import noruen.space.Cell;

import java.util.Map;
import java.util.Objects;

public class BasalDendrite extends Dendrite {
    public BasalDendrite(int index, Neuron neuron) {
        super(neuron);
        this.id = String.format("%d_BasalDendrite_%d_%d_%d", index, this.x, this.y, this.z);
        grow();
    }


    @Override
    public void grow() {
        // TODO: implement a way to allow dendrites to grow stronger into a lateral a direction.
        if (Objects.equals(neuron.id, "Neuron_28_0_0")) {
            System.out.println("Here");
        }

        Cell neighbour;

        if (body.isNewBorn()) {
            body.growToCell(neuron);
            neighbour = neuron.layer.getRandomNeighbourOfCell(neuron);
        } else {
            neighbour = neuron.layer.getNeighbourCellInDirection(body.direction, body.getHead());
        }
        body.growToCell(neighbour);
        neighbour.addCell(CellType.BASAL_DENDRITE, this);

    }

}
