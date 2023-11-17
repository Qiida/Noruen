package noruen.physic.space.cell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {
    @Test
    public void createId() {
        Assertions.assertEquals("4_3_6", Cell.createId(4, 3, 6));
    }

    @Test
    public void constructorTest() {
        Cell cell = new Cell(4, 3, 6);
        Assertions.assertEquals(4, cell.x);
        Assertions.assertEquals(3, cell.y);
        Assertions.assertEquals(6, cell.z);
        Assertions.assertEquals("4_3_6", cell.id);
    }
}
