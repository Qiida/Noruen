package noruen.physic.space;


import noruen.physic.space.cell.Cell;
import noruen.physic.space.cell.CellFactory;


public class Space {
    public final int dimX;
    public final int dimY;
    public final int dimZ;

    public final Cell[][][] cells;

    public Space(int dimX, int dimY, int dimZ) {
        if (dimX < 1 || dimY < 1 ||dimZ < 1) {
            throw new IllegalArgumentException("Dimensions must be at least 1");
        }
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;

        cells = CellFactory.buildCellsFromDimensions(dimX, dimY, dimZ);
    }

    public Cell getCell(int x, int y, int z) {
        if (x >= dimX || y >= dimY || z >= dimZ) {
            throw new IndexOutOfBoundsException("Coordinates are out of bounds");
        }
        return cells[x][y][z];
    }



    public int getNumberOfCells() {
        return dimX * dimY * dimZ;
    }



}
