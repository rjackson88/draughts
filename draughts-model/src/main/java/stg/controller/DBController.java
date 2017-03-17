package stg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import stg.model.board.Board;

/**
 * Created by prestonbattin on 3/16/17.
 */
@Controller
@CrossOrigin
public class DBController {

    @RequestMapping(value = "/save", method = RequestMethod.PUT, consumes = {"application/json"})
    @ResponseBody public String create(@RequestBody Board board){

        try{
            BoardEntity updateSave = boardDOA.findByid(1);
            updateSave.setBoard(board.getBoard());
            updateSave.setBlackCount(board.getBlackCount());

            updateSave.setMustJump(board.isMustJump());
            updateSave.setWhiteCount(board.getWhiteCount());
            updateSave.setPositionFrom(board.getPositionFrom());
            updateSave.setPositionTo(board.getPositionTo());
        }
        catch(Exception e){
            BoardEntity boardEntity = new BoardEntity(board.getBoard(), board.getPositionFrom(), board.getPositionTo(),
                    board.getWhiteCount(), board.getBlackCount(), board.isMustJump());
                    boardDOA.save(boardEntity);
                    return "New Game Saved!";
        }
        return "Game Saved!";
    }

    @RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody public BoardEntity load(){

        try{
            BoardEntity boardEntity = boardDOA.findByid(1);
            return boardEntity;
        }
        catch(Exception e){
            return null;
        }
    }

    @Autowired
    private BoardDOA boardDOA;
}
