package stg.controller;

import org.springframework.web.bind.annotation.*;
import stg.model.board.Board;
import stg.model.game.Game;

/**
 * Created by prestonbattin on 3/16/17.
 */
@RestController
@CrossOrigin
public class GameController {

    @RequestMapping(value = "/clearMoves", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public Game clearMoves(@RequestBody Game game){

        Board.clearMoves(game.getBoard());
        return game;
    }

    @RequestMapping(value = "/newGame", method = RequestMethod.GET)
    public Game newGame(){
        return new Game();
    }

    @RequestMapping(value = "/movePiece", method = RequestMethod.POST, consumes = {"application/json"})
    public Game movePiece(@RequestBody Game game){


    }
}
