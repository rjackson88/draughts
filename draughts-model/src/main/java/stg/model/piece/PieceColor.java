package stg.model.piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public enum PieceColor {
    
    WHITE {
        @Override
        public String toString() {
            return "White";
        }
    },
    
    EMPTY {
        @Override
        public String toString() {
            return "Empty";
        }
    },
    
    BLACK {
        @Override
        public String toString() {
            return "Black";
        }
    };
    
    private static final PieceColor[] ENUMS = PieceColor.values();
    
    public int getValue() {
        return ordinal() - 1;
    }
    
    public PieceColor getColor(int i) {
        return ENUMS[i + 1];
    }
}
