package com.ohgiraffers.test.board.repository;

import com.ohgiraffers.test.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Integer>{
   // Optional<Board> findBoardsById(Integer boardId);
    //Select * from board where id = ?
}
