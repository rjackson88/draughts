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
    },
    
    TRANSPARENT {
        
    };
    
    private static final PieceColor[] ENUMS = PieceColor.values();
    
    public int getValue() {
        if (ordinal() == 3) {
            return -3;
        } else {
            return ordinal() - 1;
        }
    }
    
    public PieceColor getColor(int i) {
        return ENUMS[i + 1];
    }
}
