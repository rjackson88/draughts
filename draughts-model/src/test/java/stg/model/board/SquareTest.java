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
    public void setCoordinatesFromSquareIndex7() {
        int[] i = {1, 6};
        assertArrayEquals(i, square1.getCoordinatesFromIndex(7));
    }
    
    @Test
    public void setCoordinatesFromSquareIndex31() {
        int[] i = {7, 6};
        assertArrayEquals(i, square1.getCoordinatesFromIndex(31));
    }
    
    @Test
    public void getRowFromIndex0() {
        assertEquals(0, square1.getRowFromIndex(0));
    }
    
    @Test
    public void getRowFromIndex3() {
        assertEquals(0, square1.getRowFromIndex(3));
    }
    
    @Test
    public void getRowFromIndex4() {
        assertEquals(1, square1.getRowFromIndex(4));
    }
    
    @Test
    public void getRowFromIndex8() {
        assertEquals(2, square1.getRowFromIndex(8));
    }
    
    @Test
    public void getRowFromIndex10() {
        assertEquals(2, square1.getRowFromIndex(10));
    }
    
    @Test
    public void getRowFromIndex15() {
        assertEquals(3, square1.getRowFromIndex(15));
    }
    
    @Test
    public void getRowFromIndex19() {
        assertEquals(4, square1.getRowFromIndex(19));
    }
    
    @Test
    public void getRowFromIndex20() {
        assertEquals(5, square1.getRowFromIndex(20));
    }
    
    @Test
    public void getRowFromIndex32() {
        assertEquals(7, square1.getRowFromIndex(31));
    }
    
    @Test
    public void getColFromIndex0() {
        assertEquals(1, square2.getColFromIndex(0));
    }
    
    @Test
    public void getColFromIndex3() {
        assertEquals(7, square2.getColFromIndex(3));
    }
    
    @Test
    public void getColFromIndex4() {
        assertEquals(0, square2.getColFromIndex(4));
    }
    
    @Test
    public void getColFromIndex12() {
        assertEquals(0, square2.getColFromIndex(12));
    }
    
    @Test
    public void getColFromIndex15() {
        assertEquals(6, square2.getColFromIndex(15));
    }
    
    @Test
    public void getColFromIndex24() {
        assertEquals(1, square2.getColFromIndex(24));
    }
    
    @Test
    public void getColFromIndex31() {
        assertEquals(6, square2.getColFromIndex(31));
    }
    
    @Test
    public void is9Odd() {
        assertTrue(square1.isOdd(31));
    }
    
    @Test
    public void is24Odd() {
        assertFalse(square1.isOdd(24));
    }
    
    @Test
    public void is0Odd() {
        assertFalse(square1.isOdd(0));
    }
    
    @Test
    public void is8ModFour() {
        assertTrue(square1.isModFour(8));
    }
    
    @Test
    public void is18ModFour() {
        assertFalse(square1.isModFour(18));
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
    public void square0Index() {
        assertEquals(0, square1.index());
    }
    
    @Test
    public void square1Index() {
        Square s = new Square(0, 3);
        assertEquals(1, s.index());
    }
    
    @Test
    public void square2Index() {
        Square s = new Square(0, 5);
        assertEquals(2, s.index());
    }
    
    @Test
    public void square3Index() {
        Square s = new Square(0, 7);
        assertEquals(3, s.index());
    }
    
    @Test
    public void square4Index() {
        Square s = new Square(1, 0);
        assertEquals(4, s.index());
    }
    
    @Test
    public void square7Index() {
        Square s = new Square(1, 6);
        assertEquals(7, s.index());
    }
    
    @Test
    public void square11Index() {
        Square s = new Square(2, 7);
        assertEquals(11, s.index());
    }
    
    @Test
    public void square16Index() {
        Square s = new Square(4, 1);
        assertEquals(16, s.index());
    }
    
    @Test
    public void square31Index() {
        Square s = new Square(7, 6);
        assertEquals(31, s.index());
    }
    
    @Test
    public void getSquare1Color() {
        assertEquals(SquareColor.DARK, square2.getColor());
    }
}
