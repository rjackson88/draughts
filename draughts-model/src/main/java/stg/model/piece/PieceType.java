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
    },
    
    SELECT {
        @Override
        public String toString() {
            return "Selected";
        }
    };
    
    public int getValue() {
        if (ordinal() == 3) {
            return -3;
        } else {
            return ordinal();
        }
    }
}
