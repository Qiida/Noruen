package noruen.space;

import noruen.neuron.CellType;
import noruen.neuron.Neuron;

import java.util.Random;

public class Layer extends Space{

    public Random random;

    private final float targetActivationLevel;


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
                    cells[x][y][z].addCell(CellType.Neuron, new Neuron(this, x, y, z));
                }
            }
        }
    }

    public Cell getRandomNeighbourOfCell(Cell cell) {
        int[] targetCoordinates = getRandomCoordinates(cell);
        while (!isValidTarget(cell, targetCoordinates)) {
            targetCoordinates = getRandomCoordinates(cell);
        }
        return getCellFromCoordinates(targetCoordinates);
    }

    private Cell getCellFromCoordinates(int[] coordinates) {
        return cells[coordinates[0]][coordinates[1]][coordinates[2]];
    }

    private boolean isValidTarget(Cell self, int[] targetCoordinates) {
        return targetCoordinates[0] >= 0 & targetCoordinates[0] < dimX &&
               targetCoordinates[1] >= 0 & targetCoordinates[1] < dimY &&
               targetCoordinates[2] >= 0 & targetCoordinates[2] < dimZ &&
               targetCoordinates[0] != self.x &&
               targetCoordinates[1] != self.y &&
               targetCoordinates[2] != self.z;
    }

    private int[] getRandomCoordinates(Cell self) {
        int[] coordinates = new int[3];
        int stepToX = random.nextInt(0, 1);
        int stepToY = random.nextInt(0, 1);
        int stepToZ = random.nextInt(0, 1);

        coordinates[0] = self.x + stepToX;
        coordinates[1] = self.y + stepToY;
        coordinates[2] = self.z + stepToZ;
        return coordinates;
    }

//    public int getTotalEnergy() {
//        int totalEnergy = 0;
//        for (Neuron[][] neuron2DArray : space) {
//            for (Neuron[] neurons : neuron2DArray) {
//                for (Neuron neuron : neurons) {
//                    totalEnergy += neuron.energy;
//                }
//            }
//        }
//        return totalEnergy;
//    }

//    public int getNumberOfNeurons() {
//        int numberOfNeurons = 0;
//        for (Neuron[][] neuron2DArray : space) {
//            for (Neuron[] neurons : neuron2DArray) {
//                for (int z = 0; z < neurons.length; z++) {
//                    numberOfNeurons++;
//                }
//            }
//        }
//        return numberOfNeurons;
//    }
//
//    public ArrayList<Neuron> getListOfNeurons() {
//        ArrayList<Neuron> listOfNeurons = new ArrayList<>();
//        for (Neuron[][] neuron2DArray : space) {
//            for (Neuron[] neurons : neuron2DArray) {
//                Collections.addAll(listOfNeurons, neurons);
//            }
//        }
//        return listOfNeurons;
//    }

//    public ArrayList<Neuron> getListOfSortedNeurons() {
//        ArrayList<Neuron> listOfNeurons = getListOfNeurons();
//        listOfNeurons.sort(Comparator.comparing(Neuron::getEnergy));
//        Collections.reverse(listOfNeurons);
//        return listOfNeurons;
//    }

//    public ArrayList<Neuron> getFiringNeurons() {
//        ArrayList<Neuron> firing = new ArrayList<>();
//        ArrayList<Neuron> sorted = getListOfSortedNeurons();
//        int numberOfFiringNeurons = (int) (this.targetActivationLevel * getNumberOfNeurons());
//
//        while (firing.size() < numberOfFiringNeurons) {
//            firing.add(sorted.remove(0));
//        }
//
//        return firing;
//    }

//    public Neuron getRandomNeuron() {
//        int x = random.nextInt(space.length);
//        int y = random.nextInt(space[0].length);
//        int z = random.nextInt(space[0][0].length);
//        return space[x][y][z];
//    }





}

