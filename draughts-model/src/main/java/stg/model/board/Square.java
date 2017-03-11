package stg.model.board;

import stg.model.piece.Piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Square {
    Node<Square> square;
    private int[] coordinates = new int[2];
    
    public Square() {
        
    }
    
    public Square(int row, int col) {
        this.coordinates[0] = row;
        this.coordinates[1] = col;
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
        
        public T get() {
            return this.square;
        }
        
        public void set(T square) {
            this.square = square;
        }
        
        public boolean isEmpty() {
            return this.piece == null;
        }
    }
}
