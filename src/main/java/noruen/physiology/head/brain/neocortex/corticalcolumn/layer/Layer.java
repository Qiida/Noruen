package noruen.physiology.head.brain.neocortex.corticalcolumn.layer;

import noruen.physic.space.cell.Cell;
import noruen.physiology.head.brain.neuron.CellType;
import noruen.physic.space.Space;
import noruen.physiology.head.brain.neuron.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Layer extends Space {

    private Random random;

    private float targetActivationLevel;

    private boolean verbose;
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public Layer(int xDim, int yDim, int zDim) {
        super(xDim, yDim, zDim);
        random = new Random();
        targetActivationLevel = 0.02f;
        populateWithNeurons();
    }

    public Layer(int xDim, int yDim, int zDim, long seed) {
        super(xDim, yDim, zDim);
        random = new Random(seed);
        targetActivationLevel = 0.02f;
        populateWithNeurons();
    }

    public Layer(int xDim, int yDim, int zDim, float targetActivationLevel) {
        super(xDim, yDim, zDim);
        random = new Random();
        this.targetActivationLevel = targetActivationLevel;
        populateWithNeurons();
    }

    public Layer(int xDim, int yDim, int zDim, long seed, float targetActivationLevel) {
        super(xDim, yDim, zDim);
        random = new Random(seed);
        this.targetActivationLevel = targetActivationLevel;
        populateWithNeurons();
    }

    private void populateWithNeurons() {
        for (int x=0; x<dimX; x++) {
            for (int y=0; y<dimY; y++) {
                for (int z=0; z<dimZ; z++) {
                    cells[x][y][z].addCell(CellType.NEURON, new Neuron(this, cells[x][y][z]));
                }
            }
        }
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public float getTargetActivationLevel() {
        return targetActivationLevel;
    }

    public void setTargetActivationLevel(float targetActivationLevel) {
        this.targetActivationLevel = targetActivationLevel;
    }


    public Cell getNeighbourCellInDirection(int[] direction, Cell cell) {
        int[] targetCoordinates = getTargetCoordinatesInDirection(direction, cell);
        if (!isWithinBorder(targetCoordinates)) {
            checkDirectionAndFix(direction, cell);
            targetCoordinates = getTargetCoordinatesInDirection(direction, cell);
        }
        return getCellFromCoordinates(targetCoordinates);
    }

    private static int[] getTargetCoordinatesInDirection(int[] direction, Cell cell) {
        int[] targetCoordinates = new int[3];
        targetCoordinates[0] = cell.x + direction[0];
        targetCoordinates[1] = cell.y + direction[1];
        targetCoordinates[2] = cell.z + direction[2];
        return targetCoordinates;
    }

    private void checkDirectionAndFix(int[] direction, Cell cell) {
        if ((cell.x == 0 && direction[0] == -1) || (cell.x == dimX-1 && direction[0] == 1)) {
            direction[0] *= -1;
            if (dimX == 1) {
                direction[0] = 0;
            }
        }
        if ((cell.y == 0 && direction[1] == -1) || (cell.y == dimY-1 && direction[1] == 1)) {
            direction[1] *= -1;
            if (dimY == 1) {
                direction[1] = 0;
            }
        }
        if ((cell.z == 0 && direction[2] == -1) || (cell.z == dimZ-1 && direction[2] == 1)) {
            direction[2] *= -1;
            if (dimZ == 1) {
                direction[2] = 0;
            }
        }
    }

    public Cell getRandomNeighbourOfCell(Cell cell) {
        int[] targetCoordinates = getRandomCoordinates(cell);
        if (!isValidTarget(cell, targetCoordinates)) {
            while (!isValidTarget(cell, targetCoordinates)) {
                targetCoordinates = getRandomCoordinates(cell);
            }
        }

        if (verbose) System.out.printf("\n\nCell: x = %d\n      y = %d\n      z = %d\n\n", cell.x, cell.y, cell.z);

        if (isValidTarget(cell, targetCoordinates)) {
            return getCellFromCoordinates(targetCoordinates);
        }
        return null;
    }

    private Cell getCellFromCoordinates(int[] coordinates) {
        return cells[coordinates[0]][coordinates[1]][coordinates[2]];
    }

    private boolean isValidTarget(Cell self, int[] targetCoordinates) {
        return isWithinBorder(targetCoordinates) &&
                atLeastOneChanged(self, targetCoordinates);
    }

    private boolean atLeastOneChanged(Cell self, int[] targetCoordinates) {
        return targetCoordinates[0] != self.x ||
                targetCoordinates[1] != self.y ||
                targetCoordinates[2] != self.z;
    }


    private boolean isWithinBorder(int[] targetCoordinates) {
        return targetCoordinates[0] >= 0 & targetCoordinates[0] < dimX &&
                targetCoordinates[1] >= 0 & targetCoordinates[1] < dimY &&
                targetCoordinates[2] >= 0 & targetCoordinates[2] < dimZ;
    }

    private int[] getRandomCoordinates(Cell self) {
        int[] coordinates = new int[3];
        int stepToX = random.nextInt(-1, 2);
        int stepToY = random.nextInt(-1, 2);
        int stepToZ = random.nextInt(-1, 2);

        coordinates[0] = self.x + stepToX;
        coordinates[1] = self.y + stepToY;
        coordinates[2] = self.z + stepToZ;
        return coordinates;
    }

    public int getTotalEnergy() {
        int totalEnergy = 0;
        for (int x=0; x<dimX; x++) {
            for (int y=0; y<dimY; y++) {
                for (int z=0; z<dimZ; z++) {
                    totalEnergy += cells[x][y][z].getNeuron().energy;
                }
            }
        }
        return totalEnergy;
    }

    public int getNumberOfNeurons() {
        return dimX * dimY * dimZ;
    }

    public ArrayList<Neuron> getListOfNeurons() {
        ArrayList<Neuron> listOfNeurons = new ArrayList<>();
        for (int x=0; x<dimX; x++) {
            for (int y=0; y<dimY; y++) {
                for (int z=0; z<dimZ; z++) {
                    listOfNeurons.add(cells[x][y][z].getNeuron());
                }
            }
        }
        return listOfNeurons;
    }

    public ArrayList<Neuron> getListOfSortedNeurons() {
        ArrayList<Neuron> listOfNeurons = getListOfNeurons();
        listOfNeurons.sort(Comparator.comparing(Neuron::getEnergy));
        Collections.reverse(listOfNeurons);
        return listOfNeurons;
    }

    public ArrayList<Neuron> getFiringNeurons() {
        ArrayList<Neuron> firing = new ArrayList<>();
        ArrayList<Neuron> sorted = getListOfSortedNeurons();
        int numberOfFiringNeurons = (int) (this.targetActivationLevel * getNumberOfNeurons());
        while (firing.size() < numberOfFiringNeurons) {
            firing.add(sorted.remove(0));
        }
        return firing;
    }

}

