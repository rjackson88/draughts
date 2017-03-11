package stg.model.piece;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/10/17.
 */
public class PieceColorTest {
    
    @Before
    public void setup() {
        
    }
    
    @Test
    public void whiteToString() {
        assertEquals("White", PieceColor.WHITE.toString());
    }
    
    @Test
    public void emptyToString() {
        assertEquals("Empty", PieceColor.EMPTY.toString());
    }
    
    @Test
    public void blackToString() {
        assertEquals("Black", PieceColor.BLACK.toString());
    }
    
    @Test
    public void getWhiteValue() {
        assertEquals(-1, PieceColor.WHITE.getValue());
    }
    
    @Test
    public void getEmptyValue() {
        assertEquals(0, PieceColor.EMPTY.getValue());
    }
    
    @Test
    public void getBlackValue() {
        assertEquals(1, PieceColor.BLACK.getValue());
    }
}
