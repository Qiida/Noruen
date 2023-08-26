package noruen.space;


public class Space {
    public final int dimX;
    public final int dimY;
    public final int dimZ;

    public final Cell[][][] cells;

    public Space(int dimX, int dimY, int dimZ) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;

        cells = buildCells(dimX, dimY, dimZ);
    }

    private Cell[][][] buildCells(int dimX, int dimY, int dimZ) {
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
