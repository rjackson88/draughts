package stg.model.board;

import com.fasterxml.jackson.annotation.JsonIgnore;
import stg.model.piece.Piece;
import stg.model.piece.PieceColor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Board {
    @JsonIgnore
    Square[][] gameBoard = new Square[8][8];
    private int[] board = new int[32];
    private int positionFrom;
    private int positionTo;
    private int whitePieceCount = 12;
    private int blackPieceCount = 12;
    private boolean mustJump = false;
    int id = 1;
    
    public Board() {
        this.board = defaultBoardArray();
        constructNewGameBoard();
        placePieces(defaultBoardArray());
    }
    
    // public Board(Square[][] gameBoard) {
    //     this.gameBoard = gameBoard;
    // }


    public int getId() {
        return id;
    }

    public Board(int[] board) {
        this.board = board;
        constructNewGameBoard();
        placePieces(board);

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
    
    public int getWhitePieceCount() {
        return whitePieceCount;
    }
    
    public void setWhitePieceCount(int whitePieceCount) {
        this.whitePieceCount = whitePieceCount;
    }
    
    public int getBlackPieceCount() {
        return blackPieceCount;
    }
    
    public void setBlackPieceCount(int blackPieceCount) {
        this.blackPieceCount = blackPieceCount;
    }
    
    int[] blankIntRow() {
        int[] r = {0, 0, 0, 0, 0, 0, 0, 0};
        return r;
    }
    
    Square[] blankSquareRow() {
        Square[] s = {null, null, null, null, null, null, null, null};
        return s;
    }
    
    public int[] blankBoardArray() {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        return a;
    }
    
    public int[] defaultBoardArray() {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                   0, 0, 0, 0, 0, 0, 0, 0,
                   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        return a;
    }
    
    // Game States
    
    private void constructNewGameBoard() {
        for (int i = 0; i < 8; i++) {
            if (isEven(i)) {
                for (int j = 1; j < 8; j++) {
                    gameBoard[i][j] = new Square(this, i, j);
                }
            } else {
                for (int j = 0; j < 8; j++) {
                    gameBoard[i][j] = new Square(this, i, j);
                }
            }
        }
    }
    
    private Square[][] placePieces(int[] board) {
        for (int i = 0; i < board.length; i++) {
            int[] c = Square.getCoordinatesFromIndex(i);
            gameBoard[c[0]][c[1]].placePiece(new Piece(board[i]));
        }
        return gameBoard;
    }
    
    private static boolean isEven(int i) {
        return i % 2 == 0;
    }
    
    // Query Operations
    
    public int[] getBoard() {
        for (int i = 0; i < 32; i++) {
            board[i] = getSquare(i).value();
        }
        return board;
    }
    
    public void setBoard(int[] board) {
        this.board = board;
        setGameBoard(placePieces(board));
    }
    
    public Square[][] getGameBoard() {
        return gameBoard;
    }
    
    public void setGameBoard(Square[][] gameBoard) {
        this.gameBoard = gameBoard;
        getBoard();
    }
    
    public Square getSquare(int[] i) {
        return gameBoard[i[0]][i[1]];
    }
    
    public Square getSquare(int i) {
        return getSquare(Square.getCoordinatesFromIndex(i));
    }
    
    public Square getSquare(int row, int col) {
        return gameBoard[row][col];
    }
    
    public boolean isEmpty(int i) {
        return getSquare(i).isEmpty();
    }
    
    public List<Integer> getAllPossibleMovers(PieceColor color) {
        mustJumpThisRound(color);
        int[] board = getBoard();
        List<Integer> movers = new ArrayList<>(32);
        
        for (int i = 0; i < 32; i++) {
            if (board[i] != 0 && getSquare(i).getPiece()
                                             .getColor().equals(color)) {
                if (getSquare(i).getPiece().move
                            .getAvailableMoves(mustJump).size() != 0) {
                    movers.add(i);
                }
            }
        }
        return movers;
    }
    
    public boolean mustJumpThisRound(PieceColor color) {
        mustJump = false;
        int[] board = getBoard();
        
        for (int i = 0; i < 32; i++) {
            if (board[i] != 0 && getSquare(i).getPiece().getColor()
                                             .equals(color)) {
                if (getSquare(i).getPiece().move.mustJump()) {
                    mustJump = true;
                }
            }
        }
        return mustJump;
    }
    
    public Piece getPiece(int index) {
        return getSquare(index).getPiece();
    }
    
    public void movePiece(int from, int to) {
        getPiece(from).move.move(to);
    }

    public void movePiece() {
       clearMoves();
        getPiece(positionFrom).move.move(positionTo);
        clearPositions();
    }
    
    public List<Integer> getAllMovesForPiece(int index) {
        return getPiece(index).move.getAvailableMoves(mustJump);
    }

    public void clearMoves() {
        for (int i = 0; i < 32; i++) {
            if (board[i] == -3) {
                board[i] = 0;
            }
        }
    }
    public void clearPositions() {
        positionFrom = 0;
        positionTo = 0;
    }
}