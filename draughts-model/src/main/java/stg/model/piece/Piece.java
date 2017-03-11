package stg.model.piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Piece {
    private PieceColor color;
    private PieceType type;
    
    public Piece() {
        
    }
    
    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    public void setColor(PieceColor color) {
        this.color = color;
    }
    
    public PieceType getType() {
        return type;
    }
    
    public void setType(PieceType type) {
        this.type = type;
    }
    
    public int value() {
        return color.getValue() * type.getValue();
    }
    
    public boolean isMan() {
        return type.equals(PieceType.MAN);
    }
    
    public boolean isKing() {
        return type.equals(PieceType.KING);
    }
    
    public boolean isCaptured() {
        return color.equals(PieceColor.EMPTY) && type.equals(PieceType.EMPTY);
    }
    
    public void capture() {
        color = PieceColor.EMPTY;
        type = PieceType.EMPTY;
    }
    
    public boolean isSameColor(Piece piece) {
        return this.getColor().equals(piece.getColor());
    }
    
    @Override
    public String toString() {
        return color.equals(PieceColor.EMPTY) && type.equals(PieceType.EMPTY)
                ? "Empty"
                : color.toString() + " " + type.toString();
    }
    
    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
