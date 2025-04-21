package com.ohgiraffers.chap08crud.board.repository;

import com.ohgiraffers.chap08crud.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> { //<엔티티, key type> : BoardRepository는 엔티티에 대해 실행(삭제 등), PK값 식별
    Optional<Board> findByBoardTitle(String boardTitle);
    //select * from board where title = ?
    Optional<Board> findByBoardTitleAndBoardIdNot(String boardTitle, int boardId);
    //select * from board whrer title = ? and id not in ? 제목을 찾는데 나 자신을 빼고 찾음 (중복제외)
    //메소드 이름을 보고 이런식으로 쿼리 생성

}
