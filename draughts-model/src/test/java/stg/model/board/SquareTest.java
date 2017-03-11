package stg.model.board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/10/17.
 */
public class SquareTest {
    private Square square1;
    private Square square2;
    
    @Before
    public void setup() {
        this.square1 = new Square(0, 1, SquareColor.DARK);
        this.square2 = new Square(7, 6, SquareColor.DARK);
    }
    
    @Test
    public void getSquare1Coordinates() {
        int[] i = {0, 1};
        assertArrayEquals(i, square1.getCoordinates());
    }
    
    @Test
    public void getSquare2Coordinates() {
        int[] i = {7, 6};
        assertArrayEquals(i, square2.getCoordinates());
    }
    
    @Test
    public void getSquare1Row() {
        assertEquals(0, square1.getRow());
    }
    
    @Test
    public void getSquare1Col() {
        assertEquals(1, square1.getCol());
    }
    
    @Test
    public void square1Index() {
        assertEquals(1, square1.index());
    }
    
    @Test
    public void square2Index() {
        assertEquals(32, square2.index());
    }
    
    @Test
    public void getSquare1Color() {
        assertEquals(SquareColor.DARK, square2.getColor());
    }
}
