package com.ohgiraffers.test.board.controller;

import com.ohgiraffers.test.board.DTO.BoardDTO;
import com.ohgiraffers.test.board.entity.Board;
import com.ohgiraffers.test.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller//디스패쳐 서블릿이 컨트롤러를 찾을 수 있게
@RequestMapping("/board") //컨트롤러 찾을 수 있게
public class BoardController {

    private final BoardService boardService; //의존성 주입 -> 유지보수 용이, 불변성 + 안정성 확보

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //1. 전체조회 (mvc 컨트롤러: 값에 대한 유효성 검사->전체조회는 매개변수x
    //1. 리소스, 2. http.method 두가지를 매핑
    //- 사용자 요청 *
    @GetMapping
    public ModelAndView findAllBoards() { //ResponseEntity<?> --> @Controller 쓸 때 사용
        //- 서비스 호출 *
        //- 게시글들을 넘겨받음 *(
       List<Board> boards = boardService.findAllBoards();
       ModelAndView mv = new ModelAndView("board");
       mv.addObject("boards", boards);

        //- 요청에 응답함 *
       return mv;

    }

    // 등록 화면
    @GetMapping("/regist")
    public String register() {
        return "board/regist";
    }

    //2. 등록
    //DTO-> 사용자가 넣은 값이랑 소통
    //DTO에 사용자가 적은 값을 넣어서 서비스 메서드 호출
    //등록에 성공 -> 홈 화면으로 돌아가기
    //등록에 실패 -> 게시글 등록화면 다시 띄워주기
    @PostMapping("/regist")//길이제한 없이 담을 수 있음
    @ResponseBody
    public String createBoard(@RequestBody BoardDTO boardDTO) {//1. 입력값
        //2. 서비스 호출 후 결과 참 또는 거짓으로 받음 (등록은 반환이 없을 수도 있음)
        boolean result = boardService.save(boardDTO);
        //3. String에 응답값 설정
        String message = "";
        if (result) {
            message = "등록 성공";
        }else{
            message = " 등록 실패";
        }
        //4. 응답값 반환
        return message;
    }

    //3. 상세조회
    //id를 기준으로 조회한다. -> 전체조회 중에서 id 값이 일치하는걸로 조회 -> id값는 URL에서 가져옴
    //
    // 1. 값에 대한 유효성 검사(원하는 id값 조회 -> 매개변수o)
    @GetMapping("/{board_id}")
    public ModelAndView findBoardById(@PathVariable("board_id") Integer boardId, ModelAndView mv){ //url에서 id값 가져옴 @RequestParam->쿼리 스트링으로 넘어오는 방식에서 사용
                                                                            //@PathVariable -> URL 경로에 포함된 변수 받기 가능
        //id값을 담아서 서비스 메서드 호출
        BoardDTO boardDTO = boardService.findBoardById(boardId);
        boardDTO.setBoardId(boardId); // boardId를 DTO에 설정
        //Board객체를 그대로 컨트롤러의 리턴값으로 보내줌 -> boardId를 받아서 맞는 board를 찾으면 HTTP 응답으로 보내줌
        mv.addObject("detail", boardDTO);
        mv.setViewName("/board/detail");

        return mv;
    }

       //4. 삭제
      //id를 기준으로 조회한다 -> 선택 조회중에서 id 값이 일치하는걸로 조회
      //조회해서 일치하는 값을 찾은 뒤 삭제

    @PostMapping("/{board_id}")
    public ModelAndView deleteBoardById(@PathVariable("board_id") Integer boardId, ModelAndView mv){
        //id 값을 담아서 서비스의 삭제 메서드 호출
         boolean result  = boardService.deleteBoardById(boardId);
        //mv를 통해 보여줌

        mv.addObject("remove", result); //remove.html , true / false
        mv.setViewName("/board/remove");
        //알러트로 사용자에게 보여주기?

        return mv;
    }

    //5. 수정 @PutMapping vs @PatchMapping 전체수정 vs 일부수정
    //우선은 전체 수정
    //이름과 내용을 바꾸기
    //수정에 성공 -> 결과값을 보여줌

    //겟매핑을 이용 -> 바꿀 것들을 보여주는 역할 -> DB에서 값을 받아와서 보여주기만 하면됨
    @GetMapping("{board_id}/update_view")
    public ModelAndView updateBoardById(@PathVariable("board_id") Integer boardId, ModelAndView mv){
        BoardDTO boardDTO = boardService.findBoardById(boardId);
        boardDTO.setBoardId(boardId); // boardId를 DTO에 설정
        mv.addObject("detail", boardDTO);
        mv.setViewName("board/update_view");
        return mv;
    }

    //포스트매핑 -> 바꾸는 메서드를 실행시키고 돌아오는 곳
    @PostMapping("/{board_id}/update")
    public String updateBoard(@PathVariable("board_id") Integer boardId, 
                             @RequestParam("boardName") String boardName,
                             @RequestParam("boardContent") String boardContent) {
        System.out.println("수정 컨트롤러 실행");
        // 수정할 데이터를 DTO에 담아서 서비스 메서드 호출
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardId(boardId);
        boardDTO.setBoardName(boardName);
        boardDTO.setBoardContent(boardContent);

        boardService.updateBoard(boardDTO);

        // 게시글 목록 페이지로 리다이렉트
        return "redirect:/board";
    }

}
