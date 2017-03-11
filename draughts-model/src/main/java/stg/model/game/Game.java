package stg.model.game;

/**
 * Created by rickjackson on 3/11/17.
 */
public class Game {
    private long id;
    private int[] board = new int[32];
    private int positionTo;
    private int positionFrom;
    private int blackPieceCount;
    private int whitePieceCount;
    private boolean whiteWinner;
    private boolean blackWinner;
    
    public Game() {
        
    }
    
    private long getId() {
        return id;
    }
    
    private void setId(long id) {
        this.id = id;
    }
    
    private int[] getBoard() {
        return board;
    }
    
    private void setBoard(int[] board) {
        this.board = board;
    }
    
    private int getPositionTo() {
        return positionTo;
    }
    
    private void setPositionTo(int positionTo) {
        this.positionTo = positionTo;
    }
    
    private int getPositionFrom() {
        return positionFrom;
    }
    
    private void setPositionFrom(int positionFrom) {
        this.positionFrom = positionFrom;
    }
    
    private int getBlackPieceCount() {
        return blackPieceCount;
    }
    
    private void setBlackPieceCount(int blackPieceCount) {
        this.blackPieceCount = blackPieceCount;
    }
    
    private int getWhitePieceCount() {
        return whitePieceCount;
    }
    
    private void setWhitePieceCount(int whitePieceCount) {
        this.whitePieceCount = whitePieceCount;
    }
    
    private boolean isWhiteWinner() {
        return whiteWinner;
    }
    
    private void setWhiteWinner(boolean whiteWinner) {
        this.whiteWinner = whiteWinner;
    }
    
    private boolean isBlackWinner() {
        return blackWinner;
    }
    
    private void setBlackWinner(boolean blackWinner) {
        this.blackWinner = blackWinner;
    }
}
