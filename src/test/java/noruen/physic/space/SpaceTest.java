package noruen.physic.space;

import noruen.physic.space.Space;
import noruen.physic.space.cell.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpaceTest {
    @Test
    public void constructorThrowsIllegalArgumentException() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Space(0, 10, 1);
        });
        String expectedMessage = "Dimensions must be at least 1";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getCellThrowsIndexOutOfBoundsException() {
        Exception exception = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            new Space(10, 10, 1).getCell(5, 5, 2);
        });
        String expectedMessage = "Coordinates are out of bounds";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getCellTest() {
        Space space = new Space(4, 10, 1);
        Cell cell = space.getCell(3, 3, 0);
        Assertions.assertEquals(3, cell.x);
        Assertions.assertEquals(3, cell.y);
        Assertions.assertEquals(0, cell.z);
    }

    @Test
    public void getNumberOfCellsTest() {
        Space space = new Space(10, 10, 4);
        Assertions.assertEquals(400, space.getNumberOfCells());
    }
}
