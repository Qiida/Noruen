package noruen.physiology.head.brain.neuron.dendrite;

import noruen.physic.space.cell.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Body {
    final HashMap<String, Cell> cellsHashMap = new HashMap<>();
    final List<String> cellKeys = new ArrayList<>();

    final public int[] direction = {0, 0, 0};

    public void growToCell(Cell cell) {
        if (!cellsHashMap.containsKey(cell.id)) {
            cellsHashMap.put(cell.id, cell);
            cellKeys.add(cell.id);
        }
        determineAndSetDirection();
    }

    private void determineAndSetDirection() {
        if (cellKeys.size() >= 2) {
            Cell head = getHead();
            Cell previousCell = cellsHashMap.get(cellKeys.get(cellKeys.size()-2));
            direction[0] = head.x - previousCell.x;
            direction[1] = head.y - previousCell.y;
            direction[2] = head.z - previousCell.z;
        }
    }

    public Cell getHead() {
        return cellsHashMap.get(cellKeys.get(cellKeys.size()-1));
    }

    public Cell getSoma() {
        return cellsHashMap.get(cellKeys.get(0));
    }

    public List<Cell> list() {
        ArrayList<Cell> cells = new ArrayList<>();
        for (String key : cellKeys) {
            cells.add(cellsHashMap.get(key));
        }
        return cells;
    }


    public boolean isNewBorn() {
        return cellKeys.size() == 0;
    }
}

