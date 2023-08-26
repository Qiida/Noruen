package noruen.neuron;

import noruen.space.Cell;
import noruen.space.Layer;
import noruen.neuron.dendrite.BasalDendrite;


import java.util.ArrayList;

public class Neuron extends Cell {

    public final ArrayList<BasalDendrite> basalDendrites = new ArrayList<>();

    public int energy;

    public Layer layer;
    public Cell cell;


    public Neuron(Layer layer, Cell cell) {
        super(cell.x, cell.y, cell.z);
        this.id = String.format("Neuron_%d_%d_%d", this.x, this.y, this.z);
        this.layer = layer;
        this.cell = cell;
        energy = layer.random.nextInt(100);
    }

    public Neuron(Layer layer, Cell cell, int energy) {
        super(cell.x, cell.y, cell.z);
        this.id = String.format("Neuron_%d_%d_%d", this.x, this.y, this.z);
        this.layer = layer;
        this.cell = cell;
        this.energy = energy;
    }

    public void fire() {
        energy--;
        energy++;
        if (basalDendrites.isEmpty()) {
            growBasalDendrite();
        } else {
            int index = layer.random.nextInt(basalDendrites.size());
            BasalDendrite basalDendrite = basalDendrites.get(index);
            basalDendrite.grow();
        }
    }


    public void growBasalDendrite() {
        basalDendrites.add(new BasalDendrite(basalDendrites.size(), this));
    }


    public int getEnergy() {
        return energy;
    }
}

