package noruen.physic.space.cell;

public class Coordinates {
    public final int x;
    public final int y;
    public final int z;
    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordinates goUp() {
        return new Coordinates(x, y+1, z);
    }

    public Coordinates goDown() {
        return new Coordinates(x, y-1, z);
    }

    public Coordinates goLeft() {
        return new Coordinates(x-1, y, z);
    }

    public Coordinates goRight() {
        return new Coordinates(x+1, y, z);
    }

    public Coordinates goAbove() {
        return new Coordinates(x, y, z+1);
    }

    public Coordinates goUnder() {
        return new Coordinates(x, y, z-1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinates other = (Coordinates) o;
        return x == other.x && y == other.y && z == other.z;
    }
}
