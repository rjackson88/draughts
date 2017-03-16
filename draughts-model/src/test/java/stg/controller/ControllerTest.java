//package stg.Controller;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import stg.model.board.Board;
//import stg.model.piece.Piece;
//
//import java.util.Map;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//public class ControllerTest {
//
//    private MockMvc gameController;
//
//    GameController controller;
//
//    @Before
//    public void setUp() {
//        this.gameController = standaloneSetup(new GameController()).build();
//    }
//
//    @Test
//    public void newBoardTestEndToEnd() throws Exception {
//        MockHttpServletRequestBuilder newBoardQuery = get("/newGame").contentType(MediaType.APPLICATION_JSON);
//        gameController.perform(newBoardQuery).andExpect(content().json(""));
//    }
//
//
//    @Test
//    public void newBoardTestMethod() {
//        Board board = controller.newGame();
//        Assert.assertEquals(32, board.getBoard().size());
//    }
//
//
//}