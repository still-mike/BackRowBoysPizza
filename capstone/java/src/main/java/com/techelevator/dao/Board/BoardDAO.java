package com.techelevator.dao.Board;

import com.techelevator.model.process.Board;

import java.util.List;

public interface BoardDAO {

    public List<Board> getAllBoards();

    public Board getBoard(long boardId);

    public Board createBoard(Board board);

    public boolean deleteBoard(long boardId);

}
