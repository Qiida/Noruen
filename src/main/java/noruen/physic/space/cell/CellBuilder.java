package noruen.physic.space.cell;

public class CellBuilder {
    private Integer x = null;
    private Integer y = null;
    private Integer z = null;

    public CellBuilder() {

    }

    public CellBuilder setX(int x) {
        this.x = x;
        return this;
    }

    public CellBuilder setY(int y) {
        this.y = y;
        return this;
    }

    public CellBuilder setZ(int z) {
        this.z = z;
        return this;
    }

    public Cell build() {
        assert (x != null && y != null && z != null);
        return new Cell(x, y, z);
    }
}
