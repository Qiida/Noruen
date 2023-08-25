package noruen.space;

import noruen.neuron.Neuron;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Layer {

    public Random random;
    public final Space[][][] space;

    private float targetActivationLevel;


    public Layer(int xDim, int yDim, int zDim) {
        random = new Random();
        space = buildSpace(xDim, yDim, zDim);
        targetActivationLevel = 0.02f;
    }

    public Layer(long seed, int xDim, int yDim, int zDim) {
        random = new Random(seed);
        space = buildSpace(xDim, yDim, zDim);
        targetActivationLevel = 0.02f;
    }

    public Layer(int xDim, int yDim, int zDim, float targetActivationLevel) {
        random = new Random();
        space = buildSpace(xDim, yDim, zDim);
        this.targetActivationLevel = targetActivationLevel;
    }

    public Layer(long seed, int xDim, int yDim, int zDim, float targetActivationLevel) {
        random = new Random(seed);
        space = buildSpace(xDim, yDim, zDim);
        this.targetActivationLevel = targetActivationLevel;
    }

    private Space[][][] buildSpace(int xDim, int yDim, int zDim) {
        final Space[][][] space = new Space[xDim][yDim][zDim];

        for (int x=0; x<space.length; x++) {
            for (int y=0; y<space[x].length; y++) {
                for (int z=0; z<space[x][y].length; z++) {
                    space[x][y][z] = new Space(x, y, z);
                }
            }
        }
        return space;
    }

    private void populateWithNeurons() {

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

