package noruen.physic.space.cell;

import noruen.physiology.head.brain.neuron.CellType;
import noruen.physiology.head.brain.neuron.Neuron;
import noruen.physiology.head.brain.neuron.dendrite.Dendrite;

import java.util.HashMap;

public class Cell {
    public final int x;
    public final int y;
    public final int z;

    public String id;
    private HashMap<String, Cell> cells = null;

    public Cell(int x, int y, int z) {
        id = String.format("%d_%d_%d", x, y, z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addCell(CellType cellType, Cell cell) {
        if (cellType == CellType.NEURON) {
            addNeuron(cell);
        } else {
            addDendrite(cellType, (Dendrite) cell);
        }
    }

    public void addNeuron(Cell neuron) {
        if (cells == null) {
            cells = new HashMap<>();
        }
        if (!cells.containsKey(neuron.id)) {
            cells.put(neuron.id, neuron);
        }
    }

    public void addDendrite(CellType cellType, Dendrite dendrite) {
        String key = cellType.name() + "_" + dendrite.neuron.x + "_" + dendrite.neuron.y + "_" + dendrite.neuron.z;
        cells.put(dendrite.id, dendrite);
    }

    public Neuron getNeuron() {
        String key = "Neuron_" + x + "_" + y + "_" + z;
        return (Neuron) cells.get(key);
    }

}
