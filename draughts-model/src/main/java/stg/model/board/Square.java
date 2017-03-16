package stg.model.board;

import stg.model.piece.Piece;
import stg.model.piece.PieceColor;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Square {
    private Board board = null;
    private Piece piece = null;
    private int[] coordinates = new int[2];
    private SquareColor color;
    private boolean selected = false;
    
    public Square() {
        
    }
    
    public Square(Board board, int row, int col, Piece piece) {
        this.board = board;
        this.coordinates[0] = row;
        this.coordinates[1] = col;
        this.piece = piece;
    }
    
    public Square(Board board, int row, int col) {
        this(row, col);
        this.board = board;
        this.color = SquareColor.DARK;
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
    
    // Query Operations
    
    public int value() {
        if (selected) {
            return -3;
        }
        return piece == null ? 0 : piece.value();
    }
    
    public Board getBoard() {
        return board;
    }
    
    public void setBoard(Board board) {
        this.board = board;
    }
    
    public Piece getPiece() {
        return piece;
    }
    
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public void placePiece(Piece piece) {
        if (piece.value() == -3) {
            selected = true;
        } else if (piece.value() == 0) {
            setPiece(null);
        } else {
            setPiece(piece);
            
            if (getPiece().getSquare() != this) {
                getPiece().setSquare(this);
            }
        }
    }
    
    public void removePiece() {
        piece = null;
    }
    
    public boolean isEmpty() {
        return value() == 0;
    }
    
    public int index() {
        return (getRow() * 4) + (getCol() / 2);
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
    
    public SquareColor getColor() {
        return color;
    }
    
    public void setColor(SquareColor color) {
        this.color = color;
    }
    
    public boolean isKingsRow() {
        return isBlackKingsRow() || isWhiteKingsRow();
    }
    
    public boolean isBlackKingsRow() {
        return getRow() == 0;
    }
    
    public boolean isWhiteKingsRow() {
        return getRow() == 7;
    }
    
    public void kingPiece() {
        if ((getPiece().getColor().equals(PieceColor.BLACK)
                && isBlackKingsRow())
            || (getPiece().getColor().equals(PieceColor.WHITE)
                && isWhiteKingsRow())) {
            getPiece().king();
        }
    }
    
    // Static Operations
    
    public static boolean containsSameColor(Square s1, Square s2) {
        return s1.getPiece().getColor().equals(s2.getPiece().getColor());
    }
    
    public static int[] getCoordinatesFromIndex(int index) {
        int[] c = new int[2];
        c[0] = getRowFromIndex(index);
        c[1] = getColFromIndex(index);
        return c;
    }
    
    public static int getRowFromIndex(int index) {
        return index / 4;
    }
    
    public static int getColFromIndex(int index) {
        int r = getRowFromIndex(index);
        int tmp =  index - r * 4;
        return isOdd(r) ? tmp * 2 : tmp * 2 + 1;
    }
    
    static boolean isOdd(int n) {
        return n % 2 != 0;
    }
    
    static boolean isModFour(int n) {
        return n % 4 == 0;
    }
    
    // Adjacent Squares
    
    public int squareIndex(Square square) {
        return square == null ? -1 : square.index();
    }
    
    public Square upLeft() {
        return getSquare(up(), left());
    }
    
    public Square upRight() {
        return getSquare(up(), right());
    }
    
    public Square downLeft() {
        return getSquare(down(), left());
    }
    
    public Square downRight() {
        return getSquare(down(), right());
    }
    
    public int up() {
        return getRow() - 1;
    }
    
    public int down() {
        return getRow() + 1;
    }
    
    public int left() {
        return getCol() - 1;
    }
    
    public int right() {
        return getCol() + 1;
    }
    
    public Square getSquare(int i, int j) {
        return isValidSquare(i, j) ? getBoard().getSquare(i, j) : null;
    }
    
    public Square getSquare(int index) {
        int[] c = Square.getCoordinatesFromIndex(index);
        return isValidSquare(c[0], c[1]) ? getBoard().getSquare(index) : null;
    }
    
    public static boolean isValidSquare(int i, int j) {
        return isValid(i) && isValid(j);
    }
    
    public static boolean isValidSquare(int index) {
        int[] c = Square.getCoordinatesFromIndex(index);
        return isValidSquare(c[0], c[1]);
    }
    
    private static boolean isValid(int i) {
        return i >= 0 && i <= 7;
    }
}
