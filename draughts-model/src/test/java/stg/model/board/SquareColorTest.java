package stg.model.board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/11/17.
 */
public class SquareColorTest {
    
    @Test
    public void lightToString() {
        assertEquals("Light", SquareColor.LIGHT.toString());
    }
    
    @Test
    public void darkToString() {
        assertEquals("Dark", SquareColor.DARK.toString());
    }
    
    @Test
    public void getLightValue() {
        assertEquals(0, SquareColor.LIGHT.getValue());
    }
    
    @Test
    public void getDarkValue() {
        assertEquals(1, SquareColor.DARK.getValue());
    }
}
