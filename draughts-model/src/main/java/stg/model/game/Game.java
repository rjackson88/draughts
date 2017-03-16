package stg.model.game;

import stg.model.board.Board;

/**
 * Created by rickjackson on 3/11/17.
 */
public class Game {
    private Board b;
    private long id;
    // private int[] board = new int[32];
    // private int positionTo;
    // private int positionFrom;
    // private int blackPieceCount;
    // private int whitePieceCount;
    // private boolean whiteWinner;
    // private boolean blackWinner;
    
    public Game() {
        
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int[] getBoard() {
        return b.getBoard();
    }
    
    public void setBoard(int[] board) {
        this.b = new Board(board);
    }
    
    public int getPositionTo() {
        return b.getPositionTo();
    }
    
    public void setPositionTo(int positionTo) {
        this.b.setPositionTo(positionTo);
    }
    
    public int getPositionFrom() {
        return this.b.getPositionTo();
    }
    
    public void setPositionFrom(int positionFrom) {
        this.b.setPositionFrom(positionFrom);
    }
    
    public int getBlackPieceCount() {
        return this.b.getBlackCount();
    }
    
    public void setBlackPieceCount(int blackPieceCount) {
        this.b.setBlackCount(blackPieceCount);
    }
    
    public int getWhitePieceCount() {
        return this.b.getWhiteCount();
    }
    
    public void setWhitePieceCount(int whitePieceCount) {
        this.b.setWhiteCount(whitePieceCount);
    }
    
    // public boolean isWhiteWinner() {
    //     return whiteWinner;
    // }
    //
    // public void setWhiteWinner(boolean whiteWinner) {
    //     this.whiteWinner = whiteWinner;
    // }
    //
    // public boolean isBlackWinner() {
    //     return blackWinner;
    // }
    //
    // public void setBlackWinner(boolean blackWinner) {
    //     this.blackWinner = blackWinner;
    // }
}
