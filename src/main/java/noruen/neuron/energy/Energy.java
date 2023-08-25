package noruen.neuron.energy;

public class Energy {
    public final String unit;

    public int value;

    public Energy(String unit) {
        this.unit = unit;
    }

    public Energy(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public int add(int value) {
        return this.value += value;
    }

    public void subtract(int value) {
        this.value -= value;
    }

    public void multiply(int value) {
        for (int i=0; i<value; i++) {
            this.value += value;
        }
//        this.value *= value;
    }
}
