package stg.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import stg.model.board.Board;

/**
 * Created by ryan on 3/15/17.
 */
public class GameControllerTest {

    GameController gameController;
    Board board;
    int[] array = {-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3,-3};

    @Before
    public void setUp() {
        gameController = new GameController();
        board = gameController.newGame();
    }

    @Test
    public void newGameTest() {
        Assert.assertTrue(board.getBoard()[20] == -1);
        Assert.assertTrue(board.getBoard()[13] == 0);
        Assert.assertTrue(board.getBoard()[11] == 1);
    }

    @Test
    public void clearMovesTest() {
        board.setBoard(array);
        gameController.clearMoves(board);
        Assert.assertFalse(board.getBoard()[0] == -3);
        Assert.assertTrue(board.getBoard()[0] == 0);
    }

    @Test
    public void movePieceTest() {
        board.setPositionFrom(12);
        board.setPositionTo(13);
        gameController.movePiece(board);

        // Check to make sure that you can't move outside confines of rules
        Assert.assertEquals(0, board.getBoard()[13]);

        board.setPositionTo(16);
        gameController.movePiece(board);
        Assert.assertEquals(1, board.getBoard()[16]);
    }

    @Test
    public void checkMovesTest() {
        array[4] = 0;
        array[5] = 0;
        board.setBoard(array);
        board.setPositionFrom(0);
        gameController.checkPossibleMoves(board);
        Assert.assertEquals(-3, board.getBoard()[4]);
        Assert.assertEquals(-3, board.getBoard()[5]);
    }



}
