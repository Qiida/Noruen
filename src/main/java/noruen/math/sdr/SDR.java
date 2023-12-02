package noruen.math.sdr;

import java.util.ArrayList;

public class SDR {
    final public int length;
    final public int[] bits;

    public SDR(int size) {
        this.length = size;
        bits = new int[size];
    }

    public SDR(int[] bits) {
        length = bits.length;
        this.bits = bits;
    }

    public SDR overlap(SDR sdr) {
        return SDR.overlap(this, sdr);
    }

    static SDR overlap(SDR sdr1, SDR sdr2) {
        assert(sdr1.length == sdr2.length);
        SDR overlap = new SDR(sdr1.length);
        for (int i=0; i< sdr1.length; i++) {
            overlap.bits[i] = (sdr1.bits[i] * sdr2.bits[i]);
        }
        return overlap;
    }

    public static boolean isValidArray(int[] bits) {
        for (int bit : bits) {
            if (bit != 0 && bit != 1) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> getOnBits() {
        ArrayList<Integer> onBits = new ArrayList<>();
        for (int i=0; i<length; i++) {
            if (bits[i] == 1) {
                onBits.add(i);
            }
        }
        return onBits;
    }

    public float getSparsity() {
        ArrayList<Integer> onBits = getOnBits();
        return onBits.size() / (float) length;
    }

    public String convertToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int bit : bits) {
            stringBuilder.append(bit);
        }
        return stringBuilder.toString();
    }

    public void activate(int bit) {
        bits[bit] = 1;
    }

    public void deactivate(int bit) {
        bits[bit] = 0;
    }

    public void print() {
        System.out.println(convertToString());
    }



}

