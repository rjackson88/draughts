package stg.model.board;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import stg.model.piece.Piece;
import stg.model.piece.PieceColor;

import java.util.List;

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
    public void defaultBoardArrayTest() {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                   0, 0, 0, 0, 0, 0, 0, 0,
                   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        assertArrayEquals(a, board.defaultBoardArray());
    }
    
    @Test
    public void setBoardTest() {
        int[] a = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                   0, 0, 0, 0, 0, 0, 0, 0,
                   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        assertEquals(1, board.getBoard()[0]);
        board.setBoard(a);
        assertEquals(0, board.getBoard()[0]);
    }
    
    @Test
    public void getGameBoardTest() {
        Square s = board.getSquare(0);
        assertEquals(s, board.getGameBoard()[0][1]);
    }
    
    @Test
    public void getSquareFromCoordinates() {
        int[] c = {0, 1};
        Square s = board.getSquare(0);
        assertEquals(s, board.getSquare(c));
    }
    
    @Test
    public void getSquareFromRowAndCol() {
        assertNotNull(board.getSquare(0, 1));
    }
    
    @Test
    public void getSquareFromIndex() {
        Square s = board.getGameBoard()[0][1];
        assertEquals(s, board.getSquare(0));
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
    
    @Test
    public void mustJumpThisRoundTest() {
        assertFalse(board.mustJumpThisRound(PieceColor.BLACK));
    }
    
    @Test
    public void getAllPossibleBlackMovers() {
        List<Integer> movers = board.getAllPossibleMovers(PieceColor.BLACK);
        assertEquals(8, (int) movers.get(0));
        assertEquals(4, movers.size());
    }
    
    @Test
    public void getAllPossibleWhiteMovers() {
        List<Integer> movers = board.getAllPossibleMovers(PieceColor.WHITE);
        assertEquals(20, (int) movers.get(0));
        assertEquals(4, movers.size());
    }
    
    @Test
    public void getPieceFromIndex() {
        Piece p = board.getSquare(0).getPiece();
        assertEquals(p, board.getPiece(0));
    }
    
    @Test
    public void movePieceFromIndex() {
        Piece p = board.getSquare(22).getPiece();
        board.movePiece(22,17);
        assertEquals(p, board.getPiece(17));
    }
    
    @Test
    public void getAllMovesForPieceAtIndex() {
        List<Integer> m = board.getAllMovesForPiece(22);
        assertEquals(17, (int) m.get(0));
        assertEquals(18, (int) m.get(1));
    }
}
