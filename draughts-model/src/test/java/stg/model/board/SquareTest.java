package stg.model.board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import stg.model.piece.Piece;

/**
 * Created by rickjackson on 3/10/17.
 */
public class SquareTest {
    private Board board;
    private Square square1;
    private Square square2;
    
    @Before
    public void setup() {
        this.board = new Board();
        this.square1 = this.board.getSquare(0);
        this.square2 = this.board.getSquare(31);
    }
    
    @Test
    public void valueOfSquare1() {
        assertEquals(1, square1.value());
    }
    
    @Test
    public void getBoard() {
        assertNotNull(square1.getBoard());
    }
    
    @Test
    public void setBoard() {
        square1.setBoard(new Board());
        assertNotNull(square1.getBoard());
    }
    
    @Test
    public void getPieceOnSquare1() {
        assertNotNull(square1.getPiece());
    }
    
    @Test
    public void setPieceTest() {
        Piece p = board.getPiece(20);
        Square s = board.getSquare(16);
        assertNull(s.getPiece());
        s.setPiece(p);
        assertNotNull(s.getPiece());
    }
    
    @Test
    public void removePieceOnSquare1() {
        square1.removePiece();
        assertNull(square1.getPiece());
    }
    
    @Test
    public void indexForSquare1() {
        assertEquals(0, square1.index());
    }
    
    @Test
    public void indexForSquare2() {
        assertEquals(31, square2.index());
    }
    
    @Test
    public void getCoordinatesForSquare1() {
        int[] i = {0, 1};
        assertArrayEquals(i, square1.getCoordinates());
    }
    
    @Test
    public void setCoordinatesForSquare2ToSquare1() {
        square2.setCoordinates(0, 1);
        assertArrayEquals(square1.getCoordinates(), square2.getCoordinates());
    }
    
    @Test
    public void getRowForSquare1() {
        assertEquals(0, square1.getRow());
    }
    
    @Test
    public void setRowForSquare1() {
        square1.setRow(1);
        assertEquals(1, square1.getRow());
    }
    
    @Test
    public void getColForSquare1() {
        assertEquals(1, square1.getCol());
    }
    
    @Test
    public void setColForSquare1() {
        square1.setCol(0);
        assertEquals(0, square1.getCol());
    }
    
    @Test
    public void getColorForSquare1() {
        assertEquals(SquareColor.DARK, square1.getColor());
    }
    
    @Test
    public void setColorForSquare1() {
        square1.setColor(SquareColor.LIGHT);
        assertEquals(SquareColor.LIGHT, square1.getColor());
    }
    
    @Test
    public void isSquare1InKingsRow() {
        assertTrue(square1.isKingsRow());
    }
    
    @Test
    public void isSquare2InKingsRow() {
        assertTrue(square2.isKingsRow());
    }
    
    @Test
    public void getCoordinatesFromIndex() {
        int[] i = {0, 1};
        assertArrayEquals(i, Square.getCoordinatesFromIndex(0));
    }
    
    @Test
    public void getRowFromIndex() {
        assertEquals(0, Square.getRowFromIndex(0));
    }
    
    @Test
    public void getColFromIndex() {
        assertEquals(1, Square.getColFromIndex(0));
    }
    
    @Test
    public void tenIsOdd() {
        assertTrue(Square.isOdd(1));
    }
    
    @Test
    public void sixteenIsModulo4() {
        assertTrue(Square.isModFour(16));
    }
}
