package noruen.physiology.head.brain.neuron.dendrite;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neuron.CellType;
import noruen.physiology.head.brain.neuron.Neuron;

public class BasalDendrite extends Dendrite {
    public BasalDendrite(int index, Neuron neuron) {
        super(neuron);
        this.id = String.format("BasalDendrite_i%d_x%d_y%d_z%d", index, this.x, this.y, this.z);
        grow();
    }


    @Override
    public void grow() {

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
