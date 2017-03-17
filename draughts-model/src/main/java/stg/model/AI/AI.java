package stg.model.AI;

import stg.model.board.Board;
import stg.model.piece.Piece;
import stg.model.piece.PieceColor;

/**
 * Created by kevinmccann on 3/8/17.
 */
public class AI {
    static final int WIN = 500;
    static final int KING = 80;
    static final int PIECE = 30;
    static final int EDGE = 4;
    static final int BACK = 1;

    static public int evaluateBoard(Board board, PieceColor color) {
        return evaluateBoardPieceAmounts(board, color) + evaluateBoardPiecePositions(board, color);
    }

    static public int evaluateBoardPieceAmounts(Board board, PieceColor color) {
        int positionScore = 0;
        for (Piece p : board.getAllPiecesOnGameboard()) {
            if(p == null)
                continue;
            if (p.getColor() == color) {
                if (p.isMan())
                    positionScore += PIECE;
                if (p.isKing())
                    positionScore += KING;
            } else {
                if (p.isMan())
                    positionScore -= PIECE;
                if (p.isKing())
                    positionScore -= KING;
            }
        }
        return positionScore;
    }

    static public int evaluateBoardPiecePositions(Board board, PieceColor color) {
        int positionScore = 0;
        for (int i = 0; i <= 31; i++) {
            if(board.getPiece(i) == null)
                continue;
            if(board.getPiece(i).getColor() == color) {
                if ((i+1) % 8 - 4 == 0 || (i+1) % 8 - 5 == 0)
                    positionScore += EDGE;
                if (i <= 4 || i >= 28)
                    positionScore += BACK;
            }
        }
        return positionScore;
    }

    static public Board getNewBoardAdvanced(Board board) {
        DecisionTreeNode dtn = new DecisionTreeNode(board);
        dtn.create(PieceColor.WHITE);
        return dtn.getMove(PieceColor.WHITE).board;
    }
}
