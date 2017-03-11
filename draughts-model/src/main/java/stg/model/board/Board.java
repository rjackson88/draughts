package stg.model.board;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Board {
    private Square[][] board = new Square[8][8];
    private int positionFrom;
    private int positionTo;
    private int whiteCount;
    private int blackCount;
    
    public Board() {
        
    }
    
    public Board(int[][] board) {
        
    }
    
    public Board(Square[][] board) {
        
    }
    
    public Board(int[] board) {
        
    }
    
    public int[] toArray() {
        return null;
    }
    
    public void setFromArray() {
        
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
