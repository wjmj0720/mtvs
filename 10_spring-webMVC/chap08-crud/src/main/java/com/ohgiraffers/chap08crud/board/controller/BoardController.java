package com.ohgiraffers.chap08crud.board.controller;

import com.ohgiraffers.chap08crud.board.dto.BoardDTO;
import com.ohgiraffers.chap08crud.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
//뷰 이름을 받고 랜더링 해주는 부분이 없어짐 -> 데이터 자체만 전송해주는 경우(중복확인) 주로 사용, html 코드가 아닌 응답 코드만 반환
//이 클래스 안의 메서드들은 웹 요청을 처리하고, 그 결과를 JSON, XML, 문자열 등으로 바로 응답한다는 뜻
@RequestMapping("/boards") //HTTP요청을 특정 메서드나 클래스에 매핑
@Validated //스프링에서 유효성 검사를 활성화하는 어노테이션, dto 타입으로 받음
public class BoardController {

    private static final Logger logger = Logger.getLogger(BoardController.class.getName()); //java에서 로그를 찍기 위한 설정

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping//url 매핑이 없는 이유 -> board로 POST 요청이 들어왔을 때 무조건 여기서 처리
    public ResponseEntity<BoardDTO> createBoard(@Validated @RequestBody BoardDTO boardDTO) { //@Validated : 유효성 검사
        //@RequestBody : 클라이언트가 HTTP 요청 바디(body)에 담아서 보낸 JSON 데이터를 자바 객체로 변환
        logger.info("post: /board"+boardDTO.getTitle());

        BoardDTO savedBoard = boardService.createBoard(boardDTO);

        if (savedBoard == null) {
            return ResponseEntity.status(500).body(null); //오류
        }else {
            return ResponseEntity.ok().body(savedBoard); //ok. 기본적으로 200번
        }
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable("boardId") int boardId, @Validated @RequestBody BoardDTO boardDTO) {
        logger.info("patch: /board"+ boardId);

        BoardDTO updateBoard = boardService.updateBoard(boardId,boardDTO);

        if (updateBoard == null) {
            return ResponseEntity.status(500).body(null);
        }else{
            return ResponseEntity.ok().body(updateBoard);
        }
    }
    // 삭제
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable("boardId") int boardId) {
        logger.info("DELETE /api/boards/{}" + boardId);
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }


    // 상세 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDTO> getBoardById(@PathVariable("boardId") int boardId) {
        logger.info("GET /api/boards/{}"+ boardId);
        BoardDTO board = boardService.getBoardById(boardId);
        return ResponseEntity.ok(board);
    }



    // 예외 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.warning("Validation error: {}"+ ex.getMessage());
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
