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
    
    public Square(int row, int col) {
        this.coordinates[0] = row;
        this.coordinates[1] = col;
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
    
    public void getCoordinates(int row, int col) {
        coordinates[0] = row;
        coordinates[1] = col;
    }
    
    public int[] getCoordinatesFromIndex(int index) {
        int[] c = new int[2];
        c[0] = getRowFromIndex(index);
        c[1] = getColFromIndex(index);
        return c;
    }
    
    public int getRowFromIndex(int index) {
        return index / 4;
    }
    
    public int getColFromIndex(int index) {
        int r = getRowFromIndex(index);
        int tmp =  index - r * 4;
        return isOdd(r) ? tmp * 2 : tmp * 2 + 1;
    }
    
    public int index() {
        return (getRow() * 4) + (getCol() / 2);
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
    
    public SquareColor getColor() {
        return color;
    }
    
    public void setColor(SquareColor color) {
        this.color = color;
    }
    
    boolean isOdd(int n) {
        return n % 2 != 0;
    }
    
    boolean isModFour(int n) {
        return n % 4 == 0;
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
