package stg.model.piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public enum PieceType {
    
    EMPTY {
        @Override
        public String toString() {
            return "Empty";
        }
    },
    
    MAN {
        @Override
        public String toString() {
            return "Man";
        }
    },
    
    KING {
        @Override
        public String toString() {
            return "King";
        }
    };
    
    public int getValue() {
        return ordinal();
    }
}
