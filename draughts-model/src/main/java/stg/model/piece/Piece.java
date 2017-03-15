package stg.model.piece;

import stg.model.board.Board;
import stg.model.board.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Piece {
    Move move = new Move(this);
    private Square square;
    private PieceColor color;
    private PieceType type;
    
    public Piece() {
        
    }
    
    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }
    
    public Piece(int value) {
        setProperties(value);
    }
    
    public Square getSquare() {
        return square;
    }
    
    public void setSquare(Square square) {
        this.square = square;
    }
    
    public void setSquare(int index) {
        this.square = getBoard().getSquare(index);
    }
    
    public Board getBoard() {
        return getSquare().getBoard();
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    public void setColor(PieceColor color) {
        this.color = color;
    }
    
    public void setColor(int i) {
        this.color = PieceColor.values()[i + 1];
    }
    
    public PieceType getType() {
        return type;
    }
    
    public void setType(PieceType type) {
        this.type = type;
    }
    
    public void setType(int i) {
        this.type = PieceType.values()[i];
    }
    
    public void setProperties(int i) {
        if (i < 0) {
            setColor(PieceColor.WHITE);
        } else if (i > 0) {
            setColor(PieceColor.BLACK);
        } else {
            setColor(PieceColor.EMPTY);
        }
        
        if (Math.abs(i) == 2) {
            setType(PieceType.KING);
        } else if (Math.abs(i) == 1) {
            setType(PieceType.MAN);
        } else {
            setType(PieceType.EMPTY);
        }
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
    
    public void capture(Piece piece) {
        piece.setProperties(0);
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
    
    static class Move extends Moves {
        private Piece piece;
        
        public Move(Piece piece) {
            this.piece = piece;
        }
        
        public int[] availableMoves() {
            return null;
        }
        
        private int[] availableUpMoves() {
            List<Integer> moves = new ArrayList<>(4);
            
            return null;
        }
        
        public boolean isEmpty(Square square) {
            return square.isEmpty();
        }
        
        public boolean isEmpty(int index) {
            return piece.getBoard().isEmpty(index);
        }
        
        private boolean isNotSameColor(Square square) {
            return !(piece.getColor().equals(square.getPiece().getColor()));
        }
        
        private boolean isValidSquare(int to) {
            return false;
        }
        
        public boolean isValid(int to) {
            Square sq = piece.getBoard().getSquare(to);
            return isEmpty(sq) && isNotSameColor(sq);
        }
    }
}
