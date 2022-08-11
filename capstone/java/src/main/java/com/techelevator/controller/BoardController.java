package com.techelevator.controller;

import com.techelevator.dao.Board.BoardDAO;
import com.techelevator.model.process.Board;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BoardController {

    private BoardDAO dao;

    public BoardController(BoardDAO boardDAO) {
        this.dao = boardDAO;
    }

    @GetMapping("/boards")
    public List<Board> getBoards() throws InterruptedException {
        Thread.sleep( 1000);
        return dao.getAllBoards();
    }

}
