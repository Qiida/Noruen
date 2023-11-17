package noruen.math.sdr;

public class Random {
    public static Random instance = null;
    private final java.util.Random random;

    public Random(java.util.Random random) {
        this.random = random;
    }
}
