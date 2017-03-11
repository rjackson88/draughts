package stg.model.piece;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/10/17.
 */
public class PieceTypeTest {
    
    @Before
    public void setup() {
        
    }
    
    @Test
    public void emptyToString() {
        assertEquals("Empty", PieceType.EMPTY.toString());
    }
    
    @Test
    public void manToString() {
        assertEquals("Man", PieceType.MAN.toString());
    }
    
    @Test
    public void kingToString() {
        assertEquals("King", PieceType.KING.toString());
    }
    
    @Test
    public void getEmptyValue() {
        assertEquals(0, PieceType.EMPTY.getValue());
    }
    
    @Test
    public void getManValue() {
        assertEquals(1, PieceType.MAN.getValue());
    }
    
    @Test
    public void getKingValue() {
        assertEquals(2, PieceType.KING.getValue());
    }
}
