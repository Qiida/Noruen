package noruen.physic.space.cell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellBuilderTest {

    @Test
    public void buildTest() {
        Cell cell = new CellBuilder().setX(2).setY(6).setZ(6).build();
        Assertions.assertEquals(2, cell.x);
        Assertions.assertEquals(6, cell.y);
        Assertions.assertEquals(6, cell.z);
    }
}
