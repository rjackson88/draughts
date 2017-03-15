package stg.model.piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import stg.model.board.Board;
import stg.model.board.Square;

import javax.persistence.criteria.CriteriaBuilder.In;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 3/10/17.
 */
public class PieceTest {
    private Piece empty;
    private Piece whiteMan;
    private Piece blackKing;
    private Board board;
    private Piece piece;
    private Piece moveCheck;
    
    @Before
    public void setup() {
        this.empty = new Piece(PieceColor.EMPTY, PieceType.EMPTY);
        this.whiteMan = new Piece(PieceColor.WHITE, PieceType.MAN);
        this.blackKing = new Piece(PieceColor.BLACK, PieceType.KING);
        this.board = new Board();
        this.piece = this.board.getSquare(0).getPiece();
        this.moveCheck = this.board.getSquare(23).getPiece();
    }
    
    @Test
    public void getPieceColor() {
        assertEquals(PieceColor.WHITE, whiteMan.getColor());
    }
    
    @Test
    public void setPieceColor() {
        assertEquals(PieceColor.EMPTY, empty.getColor());
        empty.setColor(PieceColor.BLACK);
        assertEquals(PieceColor.BLACK, empty.getColor());
    }
    
    @Test
    public void setPieceColorWithInt() {
        assertEquals(PieceColor.EMPTY, empty.getColor());
        empty.setColor(1);
        assertEquals(PieceColor.BLACK, empty.getColor());
    }
    
    @Test
    public void getPieceType() {
        assertEquals(PieceType.KING, blackKing.getType());
    }
    
    @Test
    public void setPieceType() {
        assertEquals(PieceType.EMPTY, empty.getType());
        empty.setType(PieceType.KING);
        assertEquals(PieceType.KING, empty.getType());
    }
    
    @Test
    public void setPieceTypeWithInt() {
        assertEquals(PieceType.EMPTY, empty.getType());
        empty.setType(2);
        assertEquals(PieceType.KING, empty.getType());
    }
    
    @Test
    public void setPieceProperties() {
        assertEquals(PieceColor.EMPTY, empty.getColor());
        assertEquals(PieceType.EMPTY, empty.getType());
        empty.setProperties(2);
        assertEquals(PieceColor.BLACK, empty.getColor());
        assertEquals(PieceType.KING, empty.getType());
    }
    
    @Test
    public void emptyPieceValue() {
        assertEquals(0, empty.value());
    }
    
    @Test
    public void whiteManValue() {
        assertEquals(-1, whiteMan.value());
    }
    
    @Test
    public void blackKingValue() {
        assertEquals(2, blackKing.value());
    }
    
    @Test
    public void whiteManIsMan() {
        assertTrue(whiteMan.isMan());
    }
    
    @Test
    public void blackKingIsMan() {
        assertFalse(blackKing.isMan());
    }
    
    @Test
    public void whiteManIsKing() {
        assertFalse(whiteMan.isKing());
    }
    
    @Test
    public void blackKingIsKing() {
        assertTrue(blackKing.isKing());
    }
    
    @Test
    public void emptyIsCaptured() {
        assertTrue(empty.isCaptured());
    }
    
    @Test
    public void whiteManIsCaptured() {
        assertFalse(whiteMan.isCaptured());
    }
    
    @Test
    public void capturePiece() {
        assertFalse(piece.isCaptured());
        piece.capture();
        assertTrue(piece.isCaptured());
    }
    
    @Test
    public void whiteManAndBlackKingAreSameColor() {
        assertFalse(whiteMan.isSameColor(blackKing));
    }
    
    @Test
    public void whiteManAndWhiteManAreSameColor() {
        assertTrue(whiteMan.isSameColor(whiteMan));
    }
    
    @Test
    public void emptyToString() {
        assertEquals("Empty", empty.toString());
    }
    
    @Test
    public void blackKingToString() {
        assertEquals("Black King", blackKing.toString());
    }
    
    // Move Tests
    
    @Test
    public void squareAtR3C4IsEmpty() {
        Square s = board.getSquare(14);
        assertTrue(piece.move.isEmpty(s));
    }
    
    @Test
    public void squareAtIndex13IsEmpty() {
        Square s = board.getSquare(13);
        assertTrue(piece.move.isEmpty(s.index()));
    }
    
    @Test
    public void pieceAtSquareAtIndex0IsNotSameAsIndex1() {
        Square s = board.getSquare(1);
        assertFalse(piece.move.isNotSameColor(s));
    }
    
    @Test
    public void pieceAtSquareAtIndex0IsNotSameAsIndex31() {
        Square s = board.getSquare(31);
        assertTrue(piece.move.isNotSameColor(s));
    }
    
    @Test
    public void movePieceToIndex18() {
        Piece p = board.getSquare(23).getPiece();
        p.move.to(18);
        assertEquals(board.getSquare(18), p.getSquare());
    }
    
    @Test
    public void isEmptyWithSquareParam() {
        Square sq = board.getSquare(0);
        assertFalse(piece.move.isEmpty(sq));
    }
    
    @Test
    public void simpleMovePieceFromIndex23ToIndex18() {
        Piece piece = board.getSquare(23).getPiece();
        assertEquals(piece, board.getSquare(23).getPiece());
        assertEquals(0, board.getSquare(18).value());
        assertNull(board.getSquare(18).getPiece());
        piece.move.simple(Direction.UP, Direction.LEFT);
        assertEquals(piece, board.getSquare(18).getPiece());
        assertNull(board.getSquare(23).getPiece());
    }
    
    @Test
    public void mustJumpTest() {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                   0, 0, 0, -1, 0, 0, 0, 0,
                   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        Board b = new Board(a);
        Piece p = b.getSquare(11).getPiece();
        Square s = b.getSquare(18);
        assertEquals(MoveType.JUMP, p.move.moveType(Direction.DOWN,
                                                    Direction.LEFT));
        assertTrue(p.move.mustJump());
        assertFalse(b.getSquare(0).getPiece().move.mustJump());
        assertEquals(s, p.move.getMoveTo(true, Direction.DOWN,
                                         Direction.LEFT));
        int[] arr = {12, 13};
    }
    
    @Test
    public void getTarget() {
        Piece p = board.getSquare(11).getPiece();
        Square s = board.getSquare(15);
        assertEquals(s, p.move.getTarget(p.getSquare(), Direction.DOWN,
                                         Direction.LEFT));
    }
    
    @Test
    public void getDirectionMoves() {
        Board b = new Board();
        Piece p = b.getSquare(9).getPiece();
        Integer[] arr = {13, 14};
        List<Integer> list = p.move.getDirectionMoves(false,
                                                      Direction.DOWN);
        assertEquals(arr[0], list.get(0));
        assertEquals(arr[1], list.get(1));
    }
    
    @Test
    public void getAvailableMoves() {
        Board b = new Board();
        Piece p = b.getSquare(22).getPiece();
        Integer[] arr = {17, 18};
        List<Integer> list = p.move.getDirectionMoves(false,
                                                      Direction.UP);
        assertEquals(arr[0], list.get(0));
        assertEquals(arr[1], list.get(1));
    }
}
