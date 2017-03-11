package stg.model.piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/10/17.
 */
public class PieceTest {
    private Piece empty;
    private Piece whiteMan;
    private Piece blackKing;
    
    @Before
    public void setup() {
        this.empty = new Piece(PieceColor.EMPTY, PieceType.EMPTY);
        this.whiteMan = new Piece(PieceColor.WHITE, PieceType.MAN);
        this.blackKing = new Piece(PieceColor.BLACK, PieceType.KING);
    }
    
    @Test
    public void getPieceColor() {
        assertEquals(PieceColor.WHITE, whiteMan.getColor());
    }
    
    @Test
    public void getPieceType() {
        assertEquals(PieceType.KING, blackKing.getType());
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
}
