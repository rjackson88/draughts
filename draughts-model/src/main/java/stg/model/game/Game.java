package stg.model.game;

/**
 * Created by rickjackson on 3/11/17.
 */
public class Game {

    private int id =1;
    private int[] board = new int[32];
    private int positionTo;
    private int positionFrom;
    private int blackPieceCount;
    private int whitePieceCount;
    private boolean whiteWinner;
    private boolean blackWinner;

    public long getId() {
        return id;
    }

    public void setId(int id) {
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
