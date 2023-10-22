package noruen.physic.space.cell;

public class CellFactory {
    public static Cell[][][] buildCells(int dimX, int dimY, int dimZ) {
        final Cell[][][] cells = new Cell[dimX][dimY][dimZ];

        for (int x=0; x<dimX; x++) {
            for (int y=0; y<dimY; y++) {
                for (int z=0; z<dimZ; z++) {
                    cells[x][y][z] = new Cell(x, y, z);
                }
            }
        }
        return cells;
    }
}
