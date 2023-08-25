package noruen.space;

import java.util.ArrayList;

public class Space {
    public final int x;
    public final int y;
    public final int z;

    public ArrayList<Element> elements = new ArrayList<>();

    public Space(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

}
