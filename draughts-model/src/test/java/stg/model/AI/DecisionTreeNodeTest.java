package stg.model.AI;

import org.junit.Before;
import org.junit.Test;
import stg.model.board.Board;
import stg.model.piece.PieceColor;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 3/13/17.
 */
public class DecisionTreeNodeTest {
    Board board;
    DecisionTreeNode testNode;

    @Before
    public void setUp() {
        board = new Board();
        testNode = new DecisionTreeNode(board);
    }


    @Test
    public void createTest() {
        testNode.create(PieceColor.BLACK);
        assertEquals(7,testNode.children.size());
    }

    @Test
    public void bestBoardPositionTest() {
        testNode.create(PieceColor.BLACK);
        int actual = testNode.bestBoardPosition(PieceColor.BLACK);
        int expected = 17;
        assertEquals(expected, actual);
    }

    @Test
    public void getBestMoveTest() {
        testNode.create(PieceColor.BLACK);
        assertTrue(testNode.getMove(PieceColor.BLACK).board instanceof Board);
    }

}