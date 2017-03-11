package stg.model.board;

import stg.model.piece.Piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Board {
    private Square[][] board = new Square[8][8];
    private int positionFrom = 0;
    private int positionTo;
    private int whiteCount;
    private int blackCount;
    
    public Board() {
        constructBoardSquares();
    }
    
    public Board(int[][] board) {
        constructBoardSquares();
    }
    
    public Board(Square[][] board) {
        this.board = board;
    }
    
    public Board(int[] board) {
        constructBoardSquares();
    }
    
    public int[] toArray() {
        return null;
    }
    
    public void setFromArray() {
        
    }
    
    public void newBoard() {
        constructBoardSquares();
    }
    
    private void constructBoardSquares() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (isEven(i)) {
                    if (isEven(j)) {
                        board[i][j] = new Square(i, j, SquareColor.LIGHT);
                    } else {
                        board[i][j] = new Square(i, j, SquareColor.DARK);
                    }
                } else {
                    if (isEven(j)) {
                        board[i][j] = new Square(i, j, SquareColor.DARK);
                    } else {
                        board[i][j] = new Square(i, j, SquareColor.LIGHT);
                    }
                }
            }
        }
    }
    
    private void setPiece(int i, int j) {
        
    }
    
    private boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    public int getPositionFrom() {
        return positionFrom;
    }
    
    public void setPositionFrom(int positionFrom) {
        this.positionFrom = positionFrom;
    }
    
    public int getPositionTo() {
        return positionTo;
    }
    
    public void setPositionTo(int positionTo) {
        this.positionTo = positionTo;
    }
    
    public int getWhiteCount() {
        return whiteCount;
    }
    
    public void setWhiteCount(int whiteCount) {
        this.whiteCount = whiteCount;
    }
    
    public int getBlackCount() {
        return blackCount;
    }
    
    public void setBlackCount(int blackCount) {
        this.blackCount = blackCount;
    }
}
