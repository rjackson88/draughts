package stg.model.piece;

/**
 * Created by rickjackson on 3/13/17.
 */
public enum Direction {
    UP(-1) {},
    DOWN(1) {},
    LEFT(-1) {},
    RIGHT(1) {};
    
    private int value;
    
    private Direction(int value) {
        this.value = value;
    }
    
    public int value() {
        return value;
    }
}
