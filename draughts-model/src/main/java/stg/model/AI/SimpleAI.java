package stg.model.AI;

import stg.model.board.Board;
import stg.model.piece.PieceColor;

public class SimpleAI {

    static public Board getNewBoardEasy(Board board) {

        int blackMover = board.getAllPossibleMovers(PieceColor.WHITE).get(0);
        int positionTo = board.getAllMovesForPiece(blackMover).get(0);
        return board.createPossibleBoardState(blackMover, positionTo);
    }

    static public Board getNewBoardMedium(Board board) {
        int numberOfPossibleMovers = board.getAllPossibleMovers(PieceColor.WHITE).size();
        int blackMover = board.getAllPossibleMovers(PieceColor.WHITE).get((int)Math.floor(Math.random() * numberOfPossibleMovers));
        int numberOfPossibleMoves = board.getAllMovesForPiece(blackMover).size();
        int positionTo = board.getAllMovesForPiece(blackMover).get((int)Math.floor(Math.random() * numberOfPossibleMoves));
        return board.createPossibleBoardState(blackMover, positionTo);
    }

    static public Board getNewBoardAdvanced(Board board) {
        DecisionTreeNode dtn = new DecisionTreeNode(board);
        dtn.create(PieceColor.WHITE);
        dtn.create(PieceColor.BLACK);
        dtn.create(PieceColor.WHITE);
        return dtn.getMove(PieceColor.WHITE).board;
    }
}
