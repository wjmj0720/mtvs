package com.ohgiraffers.chap08crud.board.service;

import com.ohgiraffers.chap08crud.board.dto.BoardDTO;
import com.ohgiraffers.chap08crud.board.entity.Board;
import com.ohgiraffers.chap08crud.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BoardService {

    private static final Logger logger = Logger.getLogger(BoardService.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BoardService.class);
    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional //AOP 트랜젝션 스크린샷 참고
    public BoardDTO createBoard(BoardDTO boardDTO) {
        logger.info("보드 추가하기 제목 : {}" + boardDTO.getTitle());

        Optional<Board> findBoard = boardRepository.findByBoardTitle(boardDTO.getTitle()); //OPtional -> 옵셔널 객체로 데이터를 바인딩해서 반환 ->
        // 존재하면 제목 중복-> throw 발생, 존재하지 않으면 -> persist처럼 boardDTO에 저장시킴
        //Board 엔티티 안에 있는 title 컬럼을 기준으로 데이터를 조회
        //옵셔널 객체로 데이터를 바인딩해서 반환한다 : return Optional.of(board); // 있으면
        //return Optional.empty();   // 없으면 -> 옵셔널 타입으로 반환
        //옵셔널로 감싸지 않으면 board가 null값일 때 NullPointerException 발생, 명시적으로 표현해줌으로써 의식적으로 체크 가능

        if (findBoard.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 제목입니다 : " + boardDTO.getTitle());
        }

        Board board = new Board(boardDTO.getTitle(), boardDTO.getContent());
        Board savedBoard = boardRepository.save(board);

        logger.info("게시판 등록 성공 : " + savedBoard.getBoardId());

        return new BoardDTO(savedBoard.getBoardId(), savedBoard.getBoardTitle(), savedBoard.getBoardContent());
    }//Board를(Board 객체가 똑같은데) 엔티티가 아닌 DTO로 반환해주는 이유 1. 다른 레리어에서 보더를 참조했을때 보더가 반환이 되고 다른 쪽에서 이용하고 커밋을 해버리면 상태변화가 그대로 반영됨
        //2. 엔티티를 반환해주면 노출되면 안되는 엔티티가 보여질 수 있음, 원하는 값만 DTO에 담아서 클라이언트에 반환

        @Transactional
        public BoardDTO updateBoard(int boardId, BoardDTO boardDTO){ //Optional 데이터가 한개만 넘어옴
            logger.info("Update board ID: " +boardId);

            Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

            Optional<Board> findBoard = boardRepository.findByBoardTitleAndBoardIdNot(boardDTO.getTitle(), boardId);

            if (findBoard.isPresent()) {
                throw new IllegalArgumentException("중복되는 제목이 존재합니다");
            }
            board.setBoardTitle(boardDTO.getTitle());
            board.setBoardContent(boardDTO.getContent());
            Board savedBoard = boardRepository.save(board);
            logger.info("board  updated: " +boardId);

            return new BoardDTO(savedBoard.getBoardId(),savedBoard.getBoardTitle(),savedBoard.getBoardContent());

        }

        @Transactional
        public void deleteBoard(int boardId) {
        logger.info("Delete board ID: " +boardId);
        //JPA에서 ID값이 존재하는지 확인하는 메서드
        boolean result = boardRepository.existsById(boardId);

        if (!result) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다" + boardId);
        }
        boardRepository.deleteById(boardId);
        logger.info("board deleted: " +boardId);
        }
        public BoardDTO getBoardId(int boardId) {
         logger.info("Get board ID: " +boardId);

         Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물 없음"+boardId));
         return new BoardDTO(board.getBoardId(), board.getBoardTitle(), board.getBoardContent());
    }

    public BoardDTO getBoardById(int boardId) {
        logger.info("get board Id : " + boardId);

        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물이 존재하지 않습니다." +boardId));
        return new BoardDTO(board.getBoardId(), board.getBoardTitle(), board.getBoardContent());
    }

}

