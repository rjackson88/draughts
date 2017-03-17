package stg.controller;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by prestonbattin on 3/16/17.
 */
@Entity
@Table(name = "checkersSavedGame")
public class BoardEntity {

    @NotNull
    private int[] board = new int[32];
    @NotNull
    private int positionFrom;
    @NotNull
    private int positionTo;
    @NotNull
    private int whiteCount;
    @NotNull
    private int blackCount;
    @NotNull
    private boolean mustJump = false;

    @Id
    private int id = 1;
    public BoardEntity(){};

    public BoardEntity(int[] board, int positionFrom, int positionTo, int whiteCount, int blackCount, boolean mustJump){

        this.board = board;
        this.positionFrom = positionFrom;
        this.positionTo = positionTo;
        this.whiteCount = whiteCount;
        this.blackCount = blackCount;
        this.mustJump = mustJump;
    }

    public int getId() {
        return id;
    }


    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
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

    public boolean isMustJump() {
        return mustJump;
    }

    public void setMustJump(boolean mustJump) {
        this.mustJump = mustJump;
    }
}
