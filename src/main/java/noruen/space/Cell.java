package noruen.space;

import noruen.neuron.CellType;
import noruen.neuron.Neuron;
import noruen.neuron.dendrite.BasalDendrite;
import noruen.neuron.dendrite.Dendrite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cell {
    public final int x;
    public final int y;
    public final int z;

    final private HashMap<String, Cell> cells = new HashMap<>();

    public Cell(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addCell(CellType cellType, Cell cell) {
        if (cellType == CellType.Neuron) {
            addNeuron(cell);
        } else {
            addDendrite(cellType, (Dendrite) cell);
        }
    }

    public void addNeuron(Cell neuron) {
        if (!cells.containsKey(CellType.Neuron.name())) {
            String key = CellType.Neuron.name() + "_" + neuron.x + "_" + neuron.y + "_" + neuron.z;
            cells.put(key, neuron);
        }
    }

    public void addDendrite(CellType cellType, Dendrite dendrite) {
        String key = cellType.name() + "_" + dendrite.neuron.x + "_" + dendrite.neuron.y + "_" + dendrite.neuron.z;
        cells.put(key, dendrite);
    }

    public Neuron getNeuron() {
        String key = "Neuron_" + x + "_" + y + "_" + z;
        return (Neuron) cells.get(key);
    }

}
