package noruen.sdr;

import java.util.ArrayList;
import java.util.Arrays;

public class SDR {
    final public int length;
    final public int[] bits;

    public SDR(int size) {
        this.length = size;
        this.bits = new int[size];
    }

    public SDR(int[] bits) {
        this.length = bits.length;
        this.bits = bits;
    }

    public SDR overlap(SDR sdr) {
        assert (this.length == sdr.length);
        SDR result = new SDR(length);

        for (int i = 0; i<this.length; i++) {
            for (int j = 0; j<sdr.length; j++) {
                result.bits[i] = (bits[i] * sdr.bits[i]);
            }
        }
        return result;
    }

    static boolean isValidArray(int[] bits) {
        for (int bit : bits) {
            if (bit != 0 && bit != 1) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getOnBits() {
        ArrayList<Integer> onBits = new ArrayList<>();
        for (int i = 0; i<this.length; i++) {
            if (this.bits[i] == 1) {
                onBits.add(i);
            }
        }
        return onBits;
    }

    public float getSparsity() {
        ArrayList<Integer> onBits = getOnBits();
        return onBits.size() / (float) length;
    }

    public String toString() {
        return Arrays.toString(bits);
    }



}

