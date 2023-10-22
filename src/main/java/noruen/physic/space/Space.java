package noruen.physic.space;


import noruen.physic.space.cell.Cell;
import noruen.physic.space.cell.CellFactory;


public class Space {
    public final int dimX;
    public final int dimY;
    public final int dimZ;

    public final Cell[][][] cells;

    public Space(int dimX, int dimY, int dimZ) {
        this.dimX = dimX;
        this.dimY = dimY;
        this.dimZ = dimZ;

        cells = CellFactory.buildCells(dimX, dimY, dimZ);
    }



}
