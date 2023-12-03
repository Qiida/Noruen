package noruen.math.sdr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class SDRTest {
    @Test
    public void createAnSDRTest() {
        SDR sdr = new SDR(10);
        for (int bit : sdr.bits) {
            Assertions.assertEquals(0, bit);
        }
    }

    @Test
    public void isValidArrayTest() {
        Assertions.assertFalse(SDR.isValidArray(new int[] {0, 1, 0, 3, 0}));
        Assertions.assertTrue(SDR.isValidArray(new int[] {0, 1, 0, 1, 0}));
    }

    @Test
    public void getSparsityTest() {
        int[] bits1 = {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0};
        SDR sdr1 = new SDR(bits1);
        float sparsity = sdr1.getSparsity();
        Assertions.assertTrue((0.27272728 - sparsity) < 0.0001);
    }

    @Test
    public void convertToStringTest() {
        SDR sdr = new SDR(100);
        sdr.activate(30);
        System.out.println(sdr.convertToString());
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
        SDR sdr1 = new SDR(new int[]{ 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0 });
        SDR sdr2 = new SDR(new int[]{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0 });
        SDR sdr3 = new SDR(new int[]{ 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0 });

        SDR overlap12 = SDR.overlap(sdr1, sdr2);
        SDR overlap13 = sdr1.overlap(sdr3);
        ArrayList<Integer> onBits12 = overlap12.getOnBits();
        Assertions.assertEquals(1, onBits12.get(0));
        Assertions.assertEquals(8, onBits12.get(1));
        ArrayList<Integer> onBits13 = overlap13.getOnBits();
        Assertions.assertEquals(1, onBits13.get(0));
        Assertions.assertEquals(6, onBits13.get(1));
        Assertions.assertEquals(8, onBits13.get(2));
    }
}
