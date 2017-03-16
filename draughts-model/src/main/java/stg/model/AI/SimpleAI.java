package stg.model.AI;

import stg.model.board.Board;
import stg.model.piece.PieceColor;

public class SimpleAI {

    static public Board getNewBoardIntermediate(Board board) {

        int blackMover = board.getAllPossibleMovers(PieceColor.BLACK).get(0);
        int positionTo = board.getAllMovesForPiece(blackMover).get(0);
        return board.createPossibleBoardState(blackMover, positionTo);
    }

    static public Board getNewBoardSimple(Board board) {
        int numberOfPossibleMovers = board.getAllPossibleMovers(PieceColor.BLACK).size();
        int blackMover = board.getAllPossibleMovers(PieceColor.BLACK).get((int)Math.floor(Math.random() * numberOfPossibleMovers));
        int numberOfPossibleMoves = board.getAllMovesForPiece(blackMover).size();
        int positionTo = board.getAllMovesForPiece(blackMover).get((int)Math.floor(Math.random() * numberOfPossibleMoves));
        return board.createPossibleBoardState(blackMover, positionTo);
    }
}
