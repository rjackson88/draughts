package stg.model.board;

/**
 * Created by rickjackson on 3/10/17.
 */
public enum SquareColor {
    
    LIGHT {
        @Override
        public String toString() {
            return "Light";
        }
    },
    
    DARK {
        @Override
        public String toString() {
            return "Dark";
        }
    };
    
    public int getValue() {
        return ordinal();
    }
}
