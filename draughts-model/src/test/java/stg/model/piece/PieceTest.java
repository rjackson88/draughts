package stg.model.piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import stg.model.board.Board;
import stg.model.board.Square;

/**
 * Created by rickjackson on 3/10/17.
 */
public class PieceTest {
    private Piece empty;
    private Piece whiteMan;
    private Piece blackKing;
    private Board board;
    private Piece piece;
    
    @Before
    public void setup() {
        this.empty = new Piece(PieceColor.EMPTY, PieceType.EMPTY);
        this.whiteMan = new Piece(PieceColor.WHITE, PieceType.MAN);
        this.blackKing = new Piece(PieceColor.BLACK, PieceType.KING);
        this.board = new Board();
        this.piece = this.board.getSquare(0).getPiece();
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
        assertFalse(blackKing.isCaptured());
        whiteMan.capture(blackKing);
        assertTrue(blackKing.isCaptured());
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
    public void isEmptyWithSquareParam() {
        Square sq = board.getSquare(0);
        assertFalse(piece.move.isEmpty(sq));
    }
    
    @Test
    public void simpleMove() {
        
    }
}
