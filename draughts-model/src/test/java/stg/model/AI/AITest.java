package stg.model.AI;

import org.junit.Before;
import org.junit.Test;
import stg.model.board.Board;
import stg.model.piece.PieceColor;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 3/15/17.
 */
public class AITest {
    Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void evaluateBoardBlackTest() throws Exception {

    }

    @Test
    public void evaluateBoardPieceAmountsBlackNewBoardTest() {
        int expected = 0;
        int actual = AI.evaluateBoardPieceAmounts(board, PieceColor.BLACK);
        assertEquals(expected, actual);
    }

    @Test
    public void evaluateBoardPieceAmountsBlackOneCaptureTest() {
        int expected = 30;
        board.movePiece(22,17);
        board.movePiece(9,13);
        board.movePiece(13, 22);
        int actual = AI.evaluateBoardPieceAmounts(board, PieceColor.BLACK);
        assertEquals(expected, actual);
    }


    @Test
    public void evaluateBoardPiecePositionsBlackTest() throws Exception {
        int expected = 17;
        int actual = AI.evaluateBoardPiecePositions(board, PieceColor.BLACK);
        assertEquals(expected, actual);
    }

}