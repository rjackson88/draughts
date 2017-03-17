package stg.model.AI;

import org.junit.Before;
import org.junit.Test;
import stg.model.board.Board;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 3/15/17.
 */
public class SimpleAITest {
    Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void getNewBoard() throws Exception {
        Board actual = SimpleAI.getNewBoardEasy(board);
        board.movePiece(8,12);
        System.out.println(board);
        System.out.println(actual);
        assertEquals(board, actual);
    }

}