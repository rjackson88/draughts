package stg.model.AI;

import stg.model.board.Board;
import stg.model.piece.PieceColor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kevinmccann on 3/15/17.
 */
public class DecisionTreeNode {
    LinkedList<DecisionTreeNode> children;
    Board board;

    public DecisionTreeNode(Board board) {
        children = new LinkedList<>();
        this.board = board;
    }

    public void create(PieceColor color) throws NullPointerException {
        for( DecisionTreeNode node : children) {
            node.create(color == PieceColor.BLACK ? PieceColor.WHITE : PieceColor.BLACK);
        }
        if(children.isEmpty()) {
            List<Integer> possibleMovers = board.getAllPossibleMovers(color);
            for(Integer pieceIndex : possibleMovers) {
                List<Integer> possibleMoves = board.getAllMovesForPiece(pieceIndex);
                for (int positionTo : possibleMoves) {
                    Board move;
                    try {
                        move = board.createPossibleBoardState(pieceIndex, positionTo);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                        continue;
                    }
                    children.add(new DecisionTreeNode(move));
                }
            }
        }
    }

    public int bestBoardPosition(PieceColor color) {
        if(children.isEmpty()) {
            return AI.evaluateBoard(board, color);
        }

        if(color == PieceColor.WHITE) {
            int max = -1000;
            for (DecisionTreeNode node : children) {
                max = Math.max(max, node.bestBoardPosition(PieceColor.BLACK));
            }
            return max;
        } else /*(color == PieceColor.BLACK)*/ {
            int min = 1000;
            for(DecisionTreeNode node : children) {
                min = Math.min(min, node.bestBoardPosition(PieceColor.BLACK));
            }
            return min;
        }
    }

    public DecisionTreeNode getMove(PieceColor color) {
        if (children.isEmpty()) {
            return null;
        }

        DecisionTreeNode best = null;
        int maxScore = (color == PieceColor.WHITE ? -10000 : 10000);
        for(DecisionTreeNode node : children) {
            int score = node.bestBoardPosition(PieceColor.WHITE);
            if(best == null || score * (color == PieceColor.WHITE ? 1 : -1) > maxScore * (color == PieceColor.WHITE ? 1 : -1)) {
                maxScore = score;
                best = node;
            }
        }
        return best;
    }
}
