package stg.model.board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by rickjackson on 3/10/17.
 */
public class BoardTest {
    private Board board;
    
    @Before
    public void setup() {
        this.board = new Board();
    }
    
    @Test
    public void blankIntRowTest() {
        int[] r = {0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(r, board.blankIntRow());
    }
    
    @Test
    public void blankSquareRowTest() {
        Square[] s = {null, null, null, null, null, null, null, null};
        assertArrayEquals(s, board.blankSquareRow());
    }
    
    @Test
    public void blankBoardArrayTest() {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                   0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(a, board.blankBoardArray());
    }
    
    @Test
    public void getSquareFromDefaultGameBoard() {
        assertNotNull(board.getSquare(0, 1));
    }
    
    @Test
    public void getBoardFromDefaultState() {
        int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                   0, 0, 0, 0, 0, 0, 0, 0,
                   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        assertArrayEquals(b, board.getBoard());
    }
    
    
    @Test
    public void squareAtIndex0IsNotEmpty() {
        assertFalse(board.isEmpty(0));
    }
    
    @Test
    public void squareAtIndex12IsEmpty() {
        assertTrue(board.isEmpty(12));
    }
}
