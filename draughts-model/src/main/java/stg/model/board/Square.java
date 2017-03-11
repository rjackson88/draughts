package stg.model.board;

import stg.model.piece.Piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Square {
    Node<Square> square;
    private int[] coordinates = new int[2];
    private SquareColor color;
    
    public Square() {
        
    }
    
    public Square(int row, int col, SquareColor color) {
        this.coordinates[0] = row;
        this.coordinates[1] = col;
        this.color = color;
    }
    
    public Square getSquare() {
        return this.square.square;
    }
    
    public int[] getCoordinates() {
        return coordinates;
    }
    
    public void setCoordinates(int row, int col) {
        coordinates[0] = row;
        coordinates[1] = col;
    }
    
    public int getRow() {
        return coordinates[0];
    }
    
    public void setRow(int row) {
        this.coordinates[0] = row;
    }
    
    public int getCol() {
        return coordinates[1];
    }
    
    public void setCol(int col) {
        this.coordinates[1] = col;
    }
    
    public int index() {
        int result = (getRow() * 4) + ((getCol() + 1) / 2);
        return (getRow() % 2 == 0) ? result : result + 1;
    }
    
    public SquareColor getColor() {
        return color;
    }
    
    public void setColor(SquareColor color) {
        this.color = color;
    }
    
    private static class Node<T extends Square> {
        Piece piece;
        T square;
        T upLeft;
        T upRight;
        T downRight;
        T downLeft;
        
        Node() {
            
        }
        
        Node(T square) {
            this.square = square;
        }
        
        public Piece get() {
            return this.piece;
        }
        
        public void set(Piece piece) {
            this.piece = piece;
        }
        
        // public T get() {
        //     return this.square;
        // }
        //
        // public void set(T square) {
        //     this.square = square;
        // }
        
        public boolean isEmpty() {
            return this.piece == null;
        }
    }
}
