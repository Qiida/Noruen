package noruen.sdr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class SDRTest {
    @Test
    public void createAnSDRTest() {
        SDR sdr = new SDR(10);
        System.out.println("Hello, there!");
    }

    @Test
    public void isValidArrayTest() {
        int[] bits = {0, 1, 0, 3, 0};
        Assertions.assertFalse(SDR.isValidArray(bits));
    }

    @Test
    public void getSparsityTest() {
        int[] bits1 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        SDR sdr1 = new SDR(bits1);
        float sparsity = sdr1.getSparsity();
        System.out.println("Wow");
    }

    @Test
    public void initializeSDR() {
        SDR sdr = new SDR(100);
        sdr.bits[30] = 1;
        float sparsity = sdr.getSparsity();
        System.out.println("Wow");
    }

    @Test
    public void toStringTest() {
        SDR sdr = new SDR(100);
        sdr.bits[30] = 1;
        System.out.println(sdr.toString());
    }


    @Test
    public void getOnBitsTest() {
        int[] bits1 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        SDR sdr1 = new SDR(bits1);
        ArrayList<Integer> onBits = sdr1.getOnBits();
        Assertions.assertEquals(1, onBits.get(0));
        Assertions.assertEquals(6, onBits.get(1));
        Assertions.assertEquals(8, onBits.get(2));
    }

    @Test
    public void overlapTest() {
        int[] bits1 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        SDR sdr1 = new SDR(bits1);
        System.out.println(sdr1.length);

        int[] bits2 = {0, 1, 0, 0, 0, 1, 0, 0, 1, 0,0};
        SDR sdr2 = new SDR(bits2);
        System.out.println(sdr2.length);

        SDR results = sdr1.overlap(sdr2);
    }
}
