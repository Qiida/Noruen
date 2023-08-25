package noruen.neuron;

import noruen.space.Cell;
import noruen.space.Layer;
import noruen.neuron.dendrite.BasalDendrite;
import noruen.neuron.dendrite.ProximalDendrite;
import noruen.neuron.dendrite.ApicalDendrite;

import java.util.ArrayList;

public class Neuron extends Cell {

    public final ArrayList<BasalDendrite> basalDendrites = new ArrayList<>();
    public final ArrayList<ProximalDendrite> proximalDendrites = new ArrayList<>();
    public final ArrayList<ApicalDendrite> apicalDendrites = new ArrayList<>();

    public int energy;

    public Layer layer;
    public Cell cell;


    public Neuron(Layer layer, Cell cell) {
        super(cell.x, cell.y, cell.z);
        this.layer = layer;
        this.cell = cell;
        energy = layer.random.nextInt(100);
    }

    public Neuron(Layer layer, Cell cell, int energy) {
        super(cell.x, cell.y, cell.z);
        this.layer = layer;
        this.cell = cell;
        this.energy = energy;
    }

    public void fire() {
        energy--;
        growBasalDendrite();
    }


    public void growBasalDendrite() {
        basalDendrites.add(new BasalDendrite(this));
    }

    public void growProximalDendrites() {
        proximalDendrites.add(new ProximalDendrite(this));
    }

    public void growApicalDendrites() {
        apicalDendrites.add(new ApicalDendrite(this));
    }

    public int getEnergy() {
        return energy;
    }
}

