package noruen.physiology.head.brain.neuron;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neuron.dendrite.Dendrite;

public class Synapse extends Cell {
    public float growth;
    public Dendrite from;
    public Dendrite to;

    public Synapse(Dendrite from, Dendrite to) {
        super(from.x, from.y, from.z);
        growth = 0.1f;

        this.from = from;
        this.to = to;

    }
}
