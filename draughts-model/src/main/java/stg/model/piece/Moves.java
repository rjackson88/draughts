package stg.model.piece;

import stg.model.board.Board;
import stg.model.board.Square;
import stg.model.piece.Piece.Move;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Moves {
    
    public enum Status {
        CONTINUE,
        END
    }
    
    // public static boolean blackJumpMoves(Board board, int turn, int from,
    //                                      int to) {
    //     List<List<Integer>> moves = new ArrayList<>();
    //
    //     for (int i = 7; i > -1; i--) {
    //         for (int j = 7; j > -1; j--) {
    //             if ()
    //         }
    //     }
    // }
    //
    // public static boolean isJump(int from, int to) {
    //     int rowFrom = Square.getRowFromIndex(from);
    //     int rowTo = Square.getRowFromIndex(to);
    //     return Math.abs(rowFrom - rowTo) == 2;
    // }
    //
    //
    // public static void move(Square square, MoveType type,
    //                         Direction upDown, Direction leftRight) {
    //     Piece p = square.getPiece();
    //
    //     if (type.equals(MoveType.SIMPLE)) {
    //         simpleMove(square, type, upDown, leftRight);
    //     } else if (type.equals(MoveType.JUMP)) {
    //         jumpMove(square, type, upDown, leftRight);
    //     }
    // }
    //
    // public static void simpleMove(Square square, MoveType type,
    //                               Direction upDown, Direction leftRight) {
    //     Piece p = square.getPiece();
    //     square.removePiece();
    //     square = square.getSquare(upDown.value(), leftRight.value());
    //     square.placePiece(p);
    // }
    //
    // public static void jumpMove(Square square, MoveType type,
    //                             Direction upDown, Direction leftRight) {
    //     Piece p = square.getPiece();
    //     square.removePiece();
    //     square = square.getSquare(upDown.value(), leftRight.value());
    //     square.getPiece().capture();
    //     square = square.getSquare(upDown.value(), leftRight.value());
    //     square.placePiece(p);
    // }
    //
    // public static Direction[] getDirection(int from, int to) {
    //     Direction[] d = new Direction[2];
    //
    //     if (difference(from, to) < 0) {
    //         return d;
    //     } else {
    //         return d;
    //     }
    // }
    //
    // private static MoveType getMoveType(int from, int to) {
    //     return Math.abs(to - from) > 5 ? MoveType.JUMP : MoveType.SIMPLE;
    // }
    //
    // private static int difference(int from, int to) {
    //     return to - from;
    // }
    //
    // private static boolean rowIsEven(int row) {
    //     return row % 2 == 0;
    // }
    //
    //
    //
    //
    // public static int getIndex(Square square) {
    //     return square == null ? -1 : square.index();
    // }
    //
    // public static boolean simpleMove(Piece piece, int to) {
    //     if (isValidMove(piece, to)) {
    //         piece.getSquare().removePiece();
    //         piece.getBoard().getSquare(to).placePiece(piece);
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }
    //
    // public static boolean jumpMove(Piece piece, int to) {
    //     return false;
    // }
    //
    // public static boolean isValidMove(Piece piece, int to) {
    //     return isValidSquare(piece, to) && isEmpty(piece, to);
    // }
    //
    // public static boolean isValidSimpleMove(Piece piece, int to) {
    //     return false;
    // }
    //
    // public static boolean isEmpty(Piece piece, int to) {
    //     return piece.getBoard().isEmpty(to);
    // }
    //
    // public static boolean isNotSameColor(Piece piece, int to) {
    //     return !(piece.getColor().equals(piece.getBoard().getSquare(to)
    //                                           .getPiece().getColor()));
    // }
    //
    // public static boolean isValidSquare(Piece piece, int to) {
    //     return piece.getSquare().isValidSquare(to);
    // }
}
