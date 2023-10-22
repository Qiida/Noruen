package noruen.physic.space.neighbourhood;

import noruen.physic.space.cell.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NeighbourhoodTest {
    @Test
    public void getVonNeumannTest() {
        Coordinates coordinates = new Coordinates(0, 0, 0);
        Coordinates[] neighbourhood = Neighbourhood.getVonNeumann(coordinates);
        Assertions.assertEquals(new Coordinates(0, 0, 1), neighbourhood[0]);
        Assertions.assertEquals(new Coordinates(0, 0, -1), neighbourhood[1]);
        Assertions.assertEquals(new Coordinates(0, 1, 0), neighbourhood[2]);
        Assertions.assertEquals(new Coordinates(1, 0, 0), neighbourhood[3]);
        Assertions.assertEquals(new Coordinates(0, -1, 0), neighbourhood[4]);
        Assertions.assertEquals(new Coordinates(-1, 0, 0), neighbourhood[5]);
    }

    @Test
    public void getMooreTest() {
        Coordinates coordinates = new Coordinates(0, 0, 0);
        Coordinates[] neighbourhood = Neighbourhood.getMoore(coordinates);

        Assertions.assertEquals(new Coordinates(0, 0, 1), neighbourhood[0]);
        Assertions.assertEquals(new Coordinates(0, 1, 1), neighbourhood[1]);
        Assertions.assertEquals(new Coordinates(1, 1, 1), neighbourhood[2]);
        Assertions.assertEquals(new Coordinates(1, 0, 1), neighbourhood[3]);
        Assertions.assertEquals(new Coordinates(1, -1, 1), neighbourhood[4]);
        Assertions.assertEquals(new Coordinates(0, -1, 1), neighbourhood[5]);
        Assertions.assertEquals(new Coordinates(-1, -1, 1), neighbourhood[6]);
        Assertions.assertEquals(new Coordinates(-1, 0, 1), neighbourhood[7]);
        Assertions.assertEquals(new Coordinates(-1, 1, 1), neighbourhood[8]);

        Assertions.assertEquals(new Coordinates(0, 1, 0), neighbourhood[9]);
        Assertions.assertEquals(new Coordinates(1, 1, 0), neighbourhood[10]);
        Assertions.assertEquals(new Coordinates(1, 0, 0), neighbourhood[11]);
        Assertions.assertEquals(new Coordinates(1, -1, 0), neighbourhood[12]);
        Assertions.assertEquals(new Coordinates(0, -1, 0), neighbourhood[13]);
        Assertions.assertEquals(new Coordinates(-1, -1, 0), neighbourhood[14]);
        Assertions.assertEquals(new Coordinates(-1, 0, 0), neighbourhood[15]);
        Assertions.assertEquals(new Coordinates(-1, 1, 0), neighbourhood[16]);

        Assertions.assertEquals(new Coordinates(0, 0, -1), neighbourhood[17]);
        Assertions.assertEquals(new Coordinates(0, 1, -1), neighbourhood[18]);
        Assertions.assertEquals(new Coordinates(1, 1, -1), neighbourhood[19]);
        Assertions.assertEquals(new Coordinates(1, 0, -1), neighbourhood[20]);
        Assertions.assertEquals(new Coordinates(1, -1, -1), neighbourhood[21]);
        Assertions.assertEquals(new Coordinates(0, -1, -1), neighbourhood[22]);
        Assertions.assertEquals(new Coordinates(-1, -1, -1), neighbourhood[23]);
        Assertions.assertEquals(new Coordinates(-1, 0, -1), neighbourhood[24]);
        Assertions.assertEquals(new Coordinates(-1, 1, -1), neighbourhood[25]);
    }

}
