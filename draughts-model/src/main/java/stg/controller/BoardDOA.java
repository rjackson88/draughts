package stg.controller;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by prestonbattin on 3/16/17.
 */
public interface BoardDOA extends CrudRepository<BoardEntity,Long> {

    public BoardEntity findByid(int id);

}
