package stg.model.game;

/**
 * Created by rickjackson on 3/11/17.
 */
public class Game {
    private long id = 1;
    private int[] board = new int[32];
    private int positionTo;
    private int positionFrom;
    private int blackPieceCount = 12;
    private int whitePieceCount = 12;
    private boolean whiteWinner = false;
    private boolean blackWinner = false;
    
    public Game() {
        for(int i = 0; i < 32; i++){
            if(i <12)
                board[i] = 1;
            if(i > 12 && i <= 19)
                board[i] = 0;
            if(i >= 20)
                board[i] = -1;
        }
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }

    public int getPositionTo() {
        return positionTo;
    }

    public void setPositionTo(int positionTo) {
        this.positionTo = positionTo;
    }

    public int getPositionFrom() {
        return positionFrom;
    }

    public void setPositionFrom(int positionFrom) {
        this.positionFrom = positionFrom;
    }

    public int getBlackPieceCount() {
        return blackPieceCount;
    }

    public void setBlackPieceCount(int blackPieceCount) {
        this.blackPieceCount = blackPieceCount;
    }

    public int getWhitePieceCount() {
        return whitePieceCount;
    }

    public void setWhitePieceCount(int whitePieceCount) {
        this.whitePieceCount = whitePieceCount;
    }

    public boolean isWhiteWinner() {
        return whiteWinner;
    }

    public void setWhiteWinner(boolean whiteWinner) {
        this.whiteWinner = whiteWinner;
    }

    public boolean isBlackWinner() {
        return blackWinner;
    }

    public void setBlackWinner(boolean blackWinner) {
        this.blackWinner = blackWinner;
    }
}
