package stg.controller;

import org.springframework.web.bind.annotation.*;
import stg.model.board.Board;

/**
 * Created by prestonbattin on 3/16/17.
 */
@RestController
@CrossOrigin
public class GameController {

    @RequestMapping(value = "/clearMoves", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Board clearMoves(@RequestBody Board board){

        board.clearMoves();
        return board;
    }

    @RequestMapping(value = "/newGame", method = RequestMethod.GET)
    public Board newGame(){
        return new Board();
    }

    @RequestMapping(value = "/movePiece", method = RequestMethod.POST, consumes = {"application/json"})
    public Board movePiece(@RequestBody Board board){

            board.movePiece();
            return board;
    }
    @RequestMapping(value = "/checkMoves", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Board checkPossibleMoves(@RequestBody Board board){

    }
}
