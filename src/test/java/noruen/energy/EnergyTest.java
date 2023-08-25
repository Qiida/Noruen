package noruen.energy;

import noruen.neuron.energy.Energy;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;


import java.util.Objects;

public class EnergyTest {

    @Test
    public void constructorTest0() {
        Energy energy = new Energy("joule");
        Assumptions.assumeTrue(Objects.equals(energy.unit, "joule"));
    }

    @Test
    public void constructorTest1() {
        Energy energy = new Energy(420, "joule");
        Assumptions.assumeTrue(energy.value == 420);
    }

    @Test
    public void addTest0() {
        Energy energy = new Energy(1, "joule");
        Assumptions.assumeTrue(2 == energy.add(1));
    }

    @Test
    public void addTest1() {
        Energy energy = new Energy(310, "joule");
        Assumptions.assumeTrue(420 == energy.add(100));
    }

}
